import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  val bw = BufferedWriter(OutputStreamWriter(System.`out`))

  val (a, b) = br.readLine().split(" ").map { it.toInt() }

  if (a % 2 == 0 || b % 2 == 0) {
    bw.write("${a * b}\n")
  } else {
    bw.write("${a * b - 1}\n")
  }

  bw.close()
  br.close()
}
