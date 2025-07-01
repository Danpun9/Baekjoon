import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  val bw = BufferedWriter(OutputStreamWriter(System.`out`))

  val t1 = br.readLine().split(" ").map { it.toInt() }.toIntArray()
  val t2 = br.readLine().split(" ").map { it.toInt() }.toIntArray()

  var s1 = 0
  var s2 = 0
  for (i in 0..4) {
    s1 += t1[i] * when (i) {
      0 -> 6
      1 -> 3
      2 -> 2
      3 -> 1
      else -> 2
    }
    s2 += t2[i] * when (i) {
      0 -> 6
      1 -> 3
      2 -> 2
      3 -> 1
      else -> 2
    }
  }

  bw.write("$s1 $s2\n")

  bw.close()
  br.close()
}
