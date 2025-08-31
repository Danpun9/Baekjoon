import java.io.*

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  val bw = BufferedWriter(OutputStreamWriter(System.`out`))

  while (true) {
    val str = br.readLine() ?: break

    bw.write("$str\n")
  }

  bw.close()
  br.close()
}