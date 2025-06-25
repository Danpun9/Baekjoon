import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  val bw = BufferedWriter(OutputStreamWriter(System.`out`))

  val n = (br.readLine().toInt() - 1) * 7 + 8

  bw.write("${2024 + if (n % 12 == 0) n / 12 - 1 else n / 12} ${if (n % 12 == 0) 12 else n % 12}\n")

  bw.close()
  br.close()
}
