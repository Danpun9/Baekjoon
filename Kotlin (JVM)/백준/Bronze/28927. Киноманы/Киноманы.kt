import java.io.*

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  val bw = BufferedWriter(OutputStreamWriter(System.`out`))

  val (t1, e1, f1) = br.readLine().split(" ").map { it.toInt() }
  val (t2, e2, f2) = br.readLine().split(" ").map { it.toInt() }

  val total1 = t1 * 3 + e1 * 20 + f1 * 120
  val total2 = t2 * 3 + e2 * 20 + f2 * 120

  if (total1 > total2) bw.write("Max\n")
  else if (total1 < total2) bw.write("Mel\n")
  else bw.write("Draw\n")

  bw.close()
  br.close()
}
