import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.pow

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  val bw = BufferedWriter(OutputStreamWriter(System.`out`))

  var (x, y) = br.readLine().split(" ").map { it.toInt() }


  val pow3 = IntArray(20) { 3.0.pow(it).toInt() }
  var cnt = 0
  for (i in pow3.indices) {
    if (pow3[i] <= maxOf(x, y)) continue
    cnt = i - 1
    break
  }

  for (i in cnt downTo 0) {
    if (x > y) x -= pow3[i]
    else y -= pow3[i]
  }

  bw.write(if (x == 0 && y == 0) "1\n" else "0\n")

  bw.close()
  br.close()
}
