import java.io.*

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  val bw = BufferedWriter(OutputStreamWriter(System.`out`))

  val sum = br.readLine().split(" ").sumOf { it.toInt() }

  val chicken = br.readLine().toInt() * 2

  if (chicken > sum) bw.write("$sum\n")
  else bw.write("${sum - chicken}\n")

  bw.close()
  br.close()
}