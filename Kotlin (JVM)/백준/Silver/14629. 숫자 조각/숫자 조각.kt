import java.io.*
import kotlin.math.abs

val visited = Array(10) { false }
var n = 0L
var len = 0
var sizeDiff = Long.MAX_VALUE
var res = -1L


fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val br = BufferedReader(InputStreamReader(System.`in`))

    n = br.readLine().toLong()
    len = n.toString().length

    if (n >= 9_876_543_210L) res = 9_876_543_210
    else dfs(0, 0)

    bw.write(res.toString())

    bw.close()
    br.close()
}

fun dfs(curr: Long, depth: Int) {
    if (depth == len) {
        if (sizeDiff > abs(n - curr)) {
            sizeDiff = abs(n - curr)
            res = curr
        }
    }

    for (i in 0..9) {
        if (!visited[i]) {
            visited[i] = true
            dfs(curr * 10 + i, depth + 1)
            visited[i] = false
        }
    }
}