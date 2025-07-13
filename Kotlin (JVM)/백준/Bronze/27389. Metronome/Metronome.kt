import java.io.*
import java.text.DecimalFormat

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  val bw = BufferedWriter(OutputStreamWriter(System.`out`))

  val n = br.readLine().toDouble() / 4.0

  bw.write(DecimalFormat("0.00").format(n))

  bw.close()
  br.close()
}
