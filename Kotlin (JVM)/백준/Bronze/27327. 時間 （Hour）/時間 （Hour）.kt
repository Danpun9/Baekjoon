import java.io.*

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  val bw = BufferedWriter(OutputStreamWriter(System.`out`))

  bw.write("${br.readLine().toInt() * (24)}")

  bw.close()
  br.close()
}
