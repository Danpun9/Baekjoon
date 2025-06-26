import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  val bw = BufferedWriter(OutputStreamWriter(System.`out`))

  val n = br.readLine().toInt()
  for (i in 0..<n) {
    for (j in 0..<i) bw.write(" ")
    for (j in 0..<n - i) bw.write("*")
    bw.write("\n")
  }

  bw.close()
  br.close()
}
