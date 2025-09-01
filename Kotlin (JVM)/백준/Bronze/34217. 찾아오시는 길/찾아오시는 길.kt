import java.io.*

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  val bw = BufferedWriter(OutputStreamWriter(System.`out`))

  val (a, b) = br.readLine().split(" ").map { it.toInt() }
  val (c, d) = br.readLine().split(" ").map { it.toInt() }

  if (a + c == b + d) bw.write("Either\n")
  else if (a + c > d + b) bw.write("Yongdap\n")
  else bw.write("Hanyang Univ.\n")
  
  bw.close()
  br.close()
}