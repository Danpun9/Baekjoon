import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.pow

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  val bw = BufferedWriter(OutputStreamWriter(System.`out`))

  val n = br.readLine().toDouble()

  bw.write(
    "${(n * (n + 1) / 2).toInt()}\n${((n) * (n + 1) / 2).pow(2).toInt()}\n${((n) * (n + 1) / 2).pow(2).toInt()}\n"
  )

  bw.close()
  br.close()
}
