import java.io.*

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  val bw = BufferedWriter(OutputStreamWriter(System.`out`))

  bw.write(if (br.readLine().toInt() % 7 == 2) "1\n" else "0\n")

  bw.close()
  br.close()
}