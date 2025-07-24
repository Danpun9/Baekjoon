import java.io.*

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  val bw = BufferedWriter(OutputStreamWriter(System.`out`))

  val n = br.readLine().toInt()
  var res = 0
  br.readLine().split(" ").map { if (it.toInt() % 2 == 0) res++ }

  bw.write(if (res * 2 > n) "Happy\n" else "Sad\n")

  bw.close()
  br.close()
}
