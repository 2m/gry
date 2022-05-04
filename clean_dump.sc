import scala.io.Source

for {
  line <- Source.fromFile("dump.txt").getLines
  values = line.split(" ")
} {
  val ts = values(1).split('.').head.drop(1)
  val byte1 = Integer.parseInt(values(14), 16)
  val byte2 = Integer.parseInt(values(15), 16)

  val v = ((byte1 * 256) + byte2) / 128.0

  println(s"$ts,$v")
}
