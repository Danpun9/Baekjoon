import java.io.*

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  val bw = BufferedWriter(OutputStreamWriter(System.`out`))

  if (br.readLine() == "1") bw.write("2\n")
  else bw.write("1\n")
  
  bw.close()
  br.close()
}