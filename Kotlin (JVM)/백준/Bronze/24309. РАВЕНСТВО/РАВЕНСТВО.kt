import java.io.*

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  val bw = BufferedWriter(OutputStreamWriter(System.`out`))

  val a = br.readLine().toBigInteger()
  val b = br.readLine().toBigInteger()
  val c = br.readLine().toBigInteger()

  bw.write("${(b.minus(c)).div(a)}\n")

  bw.close()
  br.close()
}