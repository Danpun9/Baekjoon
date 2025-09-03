import java.io.*

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  val bw = BufferedWriter(OutputStreamWriter(System.`out`))

  val (l, m) = br.readLine().split(" ").map { it.toInt() }
  val arr = br.readLine().split(" ").map { it.toInt() }.toIntArray()

  arr.forEach { bw.write("${it - l * m} ") }

  bw.close()
  br.close()
}