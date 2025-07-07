import java.io.*

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  val bw = BufferedWriter(OutputStreamWriter(System.`out`))

  val n = br.readLine().toInt()

  bw.write("${IntArray(n) { br.readLine().toInt() }.sum()}\n")

  bw.close()
  br.close()
}
