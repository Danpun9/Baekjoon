import java.io.*

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  val bw = BufferedWriter(OutputStreamWriter(System.`out`))

  var n = 1
  while (true) {
    val str = br.readLine()

    if (str != "0") bw.write("Case ${n++}: Sorting... done!\n")
    else break
  }

  bw.close()
  br.close()
}