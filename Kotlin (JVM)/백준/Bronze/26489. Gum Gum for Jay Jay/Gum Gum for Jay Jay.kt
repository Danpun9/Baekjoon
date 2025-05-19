import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  val bw = BufferedWriter(OutputStreamWriter(System.`out`))

  var res = 0
  while (true) {
    val str = br.readLine() ?: break
    res++
  }

  bw.write("$res\n")

  bw.close()
  br.close()
}
