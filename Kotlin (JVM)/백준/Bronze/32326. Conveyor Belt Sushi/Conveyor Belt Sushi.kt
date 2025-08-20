import java.io.*

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  val bw = BufferedWriter(OutputStreamWriter(System.`out`))

  var p = 3
  val arr = IntArray(3) { br.readLine().toInt() * p++ }

  bw.write("${arr.sum()}\n")

  bw.close()
  br.close()
}