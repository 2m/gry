// using scala 3.1.2

import scala.io.Source

for {
  line <- Source.fromFile("log.txt").getLines
  values = line.split(",").toList
  if values.size > 1
  ts :: value :: Nil = values
  if !value.exists(_.isLetter)
  parsed = BigDecimal(value.replace(' ', '.'))
} {
  val rendered =
    if (parsed > 10_000) (parsed / 1_000).toString
    else if (parsed > 1_000) (parsed / 100).toString
    else if (parsed > 100) (parsed / 10).toString
    else parsed
  println(s"$ts,$rendered")
}
