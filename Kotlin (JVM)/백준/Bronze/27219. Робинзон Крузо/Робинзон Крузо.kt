import java.io.*

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  val bw = BufferedWriter(OutputStreamWriter(System.`out`))

  val n = br.readLine().toInt()

  repeat(n / 5) { bw.write("V") }
  repeat(n % 5) { bw.write("I") }

  bw.close()
  br.close()
}
