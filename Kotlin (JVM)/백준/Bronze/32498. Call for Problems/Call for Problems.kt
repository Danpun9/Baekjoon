import java.io.*

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  val bw = BufferedWriter(OutputStreamWriter(System.`out`))

  var res = 0

  repeat(br.readLine().toInt()) {
    if (br.readLine().toInt() % 2 != 0) res++
  }

  bw.write("$res\n")

  bw.close()
  br.close()
}