import java.io.*

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  val bw = BufferedWriter(OutputStreamWriter(System.`out`))

  bw.write("${br.readLine().toDouble().toInt()}")

  bw.close()
  br.close()
}