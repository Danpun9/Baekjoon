import java.io.*

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  val bw = BufferedWriter(OutputStreamWriter(System.`out`))

  val (m, k) = br.readLine().split(" ").map { it.toInt() }

  bw.write(if (m % k == 0) "Yes\n" else "No\n")

  bw.close()
  br.close()
}
