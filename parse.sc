// scala 2.13.6

import $ivy.`com.lihaoyi::ujson:1.4.3`
import ammonite.ops._

case class Command(frame: Int, req: String, resp: List[String])

val json = ujson.read(read(pwd / "ese_1350_on_1400_off.json"))

val entries = for {
  entry <- json.arr
} yield {
  val frame = entry("_source")("layers")("frame")("frame.number").str.toInt
  val dir = entry("_source")("layers")("frame")("frame.p2p_dir").str
  val bytes = entry("_source")("layers")("btspp")("btspp.data").str
  val decoded = bytes.split(":").map(Integer.parseInt(_, 16).toChar).mkString
  (frame, dir, decoded.replaceAll("\r", ""))
}

var frame = Option.empty[Int]
var req = Option.empty[String]
var resp = List.empty[String]

val parsed = entries.flatMap { case (f, dir, data) =>
  dir match {
    case "0" =>
      val res =
        if (req.isDefined) Some(Command(frame.get, req.get, resp)) else None
      frame = Some(f)
      req = Some(data)
      resp = List.empty
      res
    case "1" => resp = resp.appended(data); None
  }
}

//println(entries)
//println(parsed)

parsed
  .filterNot(c => c.frame > 357 && c.frame < 1351)
  .filterNot(_.frame > 1400)
  .foreach { c =>
    println(
      s"""Command(${c.frame}, "${c.req}", ${c.resp.map(r => s"\"$r\"")}),"""
    )
  }
