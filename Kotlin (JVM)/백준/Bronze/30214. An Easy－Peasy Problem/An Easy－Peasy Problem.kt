import java.io.*

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  val bw = BufferedWriter(OutputStreamWriter(System.`out`))

  val (s1, s2) = br.readLine().split(" ").map { it.toInt() }

  if (s1 * 2 >= s2) bw.write("E\n")
  else bw.write("H\n")

  bw.close()
  br.close()
}