import java.io.*

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  val bw = BufferedWriter(OutputStreamWriter(System.`out`))

  val n = br.readLine().toInt()

  for (i in 1..n) bw.write("Hello World, Judge $i!\n")

  bw.close()
  br.close()
}
