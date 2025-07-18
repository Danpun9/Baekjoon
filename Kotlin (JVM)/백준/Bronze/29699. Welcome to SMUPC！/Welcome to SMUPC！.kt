import java.io.*

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  val bw = BufferedWriter(OutputStreamWriter(System.`out`))

  val n = (br.readLine().toInt() - 1) % 14

  val str = "WelcomeToSMUPC"

  bw.write("${str[n]}\n")

  bw.close()
  br.close()
}