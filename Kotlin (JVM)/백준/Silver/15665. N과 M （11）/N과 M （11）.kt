import java.io.*

val bw = BufferedWriter(OutputStreamWriter(System.`out`))

lateinit var arr: MutableSet<Int>
var M = -1

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))

  val (n, m) = br.readLine().split(" ").map { it.toInt() }
  M = m

  arr = br.readLine().split(" ").map { it.toInt() }.sorted().toMutableSet()

  dfs("", 0)

  bw.close()
  br.close()
}

fun dfs(str: String, depth: Int) {
  if (depth == M) {
    bw.write("$str\n")
    return
  }

  arr.forEach { dfs(if (depth == 0) "$it" else "$str $it", depth + 1) }
}