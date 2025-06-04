import java.io.*

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  val bw = BufferedWriter(OutputStreamWriter(System.`out`))

  repeat(br.readLine().toInt()) {
    val n = br.readLine().toInt()

    bw.write("$n $n\n")
  }
  
  bw.close()
  br.close()
}