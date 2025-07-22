import java.io.*

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  val bw = BufferedWriter(OutputStreamWriter(System.`out`))

  val n = br.readLine().toInt()

  val cup = BooleanArray(4) { false }
  cup[1] = true

  repeat(n) {
    val (a, b) = br.readLine().split(" ").map { it.toInt() }

    val temp = cup[a]
    cup[a] = cup[b]
    cup[b] = temp
  }

  cup.forEachIndexed { index, it -> if (it) bw.write("$index\n") }

  bw.close()
  br.close()
}