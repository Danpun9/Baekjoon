import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  val bw = BufferedWriter(OutputStreamWriter(System.`out`))

  var res = -1

  val n = br.readLine().toInt()

  repeat(n) {
    val (a, b, c) = br.readLine().split(" ").map { it.toInt() }

    if (a == b && b == c) {
      res = maxOf(res, 10000 + a * 1000)
    } else if (a == b || b == c || c == a) {
      val eq = if (a == b) a else if (b == c) b else c

      res = maxOf(res, 1000 + eq * 100)
    } else {
      res = maxOf(res, maxOf(maxOf(a, b), c) * 100)
    }
  }

  bw.write("$res\n")

  bw.close()
  br.close()
}
