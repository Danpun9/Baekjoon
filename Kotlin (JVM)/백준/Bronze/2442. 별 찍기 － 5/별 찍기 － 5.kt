import java.io.*

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  val bw = BufferedWriter(OutputStreamWriter(System.`out`))

  val n = br.readLine().toInt()
  
  for (i in 1..n) {
    for (j in n - i - 1 downTo 0) bw.write(" ")
    for (j in 0..<2 * i - 1) bw.write("*")
    bw.write("\n")
  }

  bw.close()
  br.close()
}