import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  val bw = BufferedWriter(OutputStreamWriter(System.`out`))

  val r = br.readLine().toInt() * 8
  val s = br.readLine().toInt() * 3

  bw.write("${r + s - 28}\n")

  bw.close()
  br.close()
}
