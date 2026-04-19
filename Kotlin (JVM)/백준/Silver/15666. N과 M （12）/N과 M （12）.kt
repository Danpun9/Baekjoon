import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val arr = IntArray(m)
    val value = br.readLine().split(" ").map { it.toInt() }.sorted()

    val sb = StringBuilder()

    fun dfs(depth: Int) {
        if (depth == m) {
            arr.forEach {
                sb.append("$it ")
            }
            sb.append("\n")
            return
        }

        var previous = -1

        for (i in 0 until n) {
            if (previous == value[i]) {
                continue
            }
            if (depth != 0 && arr[depth - 1] > value[i]) {
                continue
            }

            previous = value[i]
            arr[depth] = value[i]
            dfs(depth + 1)
        }
    }

    dfs(0)

    bw.write(sb.toString())

    bw.close()
    br.close()
}