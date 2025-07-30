import java.io.*

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  val bw = BufferedWriter(OutputStreamWriter(System.`out`))

  var h1 = br.readLine().toInt()
  if (h1 >= 20) h1 = h1 - 24

  val h2 = br.readLine().toInt()

  bw.write("${h2 - h1}")

  bw.close()
  br.close()
}