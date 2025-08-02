import java.io.*

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  val bw = BufferedWriter(OutputStreamWriter(System.`out`))

  val n = IntArray(3) { br.readLine().toInt() }.sum()

  bw.write(if (n <= 21) "1\n" else "0\n")

  bw.close()
  br.close()
}