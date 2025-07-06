import java.io.*

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  val bw = BufferedWriter(OutputStreamWriter(System.`out`))

  val (h, m) = br.readLine().split(" ").map { it.toInt() }

  bw.write("${(h - 9) * 60 + m}\n")

  bw.close()
  br.close()
}
