import java.io.*

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  val bw = BufferedWriter(OutputStreamWriter(System.`out`))

  val n = br.readLine().toInt()

  for (i in 1..n) {
    for (j in n downTo i + 1) {
      bw.write(" ")
    }

    for (j in 0..<i) {
      bw.write("* ")
    }
    bw.write("\n")
  }

  bw.close()
  br.close()
}