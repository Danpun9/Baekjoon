import java.io.*

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  val bw = BufferedWriter(OutputStreamWriter(System.`out`))

  val (b, k) = br.readLine().split(" ").map { it.toInt() }
  val wine = br.readLine().split(" ").map { it.toInt() }.toIntArray().sorted()

  var left = 0
  var right = wine.size - 1
  var cnt = 0
  var prev = 0
  var res = 0L
  
  while (cnt++ < k) {
    if (cnt % 2 == 1) res += wine[right--] - prev
    else prev = wine[left++]
  }

  bw.write("$res\n")

  bw.close()
  br.close()
}