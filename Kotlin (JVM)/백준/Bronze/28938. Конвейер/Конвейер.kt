import java.io.*

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  val bw = BufferedWriter(OutputStreamWriter(System.`out`))

  br.readLine()
  val sum = br.readLine().split(" ").map { it.toInt() }.toIntArray().sum()

  if (sum == 0) bw.write("Stay\n")
  else if (sum > 0) bw.write("Right\n")
  else bw.write("Left\n")

  bw.close()
  br.close()
}
