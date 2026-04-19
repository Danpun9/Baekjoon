import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.max

lateinit var paper: Array<IntArray>
lateinit var visited: Array<BooleanArray>

lateinit var n: IntArray

var res = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    n = br.readLine().split(" ").map { it.toInt() }.toIntArray()

    paper = Array(n[0]) { br.readLine().split(" ").map { it.toInt() }.toIntArray() }
    visited = Array(n[0]) { BooleanArray(n[1]) }

    for (i in 0 until n[0]) {
        for (j in 0 until n[1]) {
            visited[i][j] = true
            dfs(j, i, paper[i][j], 1)
            visited[i][j] = false
        }
    }

    bw.write("$res")

    bw.close()
    br.close()
}

val dx = arrayOf(1, -1, 0, 0)
val dy = arrayOf(0, 0, 1, -1)

fun dfs(x: Int, y: Int, sum: Int, depth: Int) {
    if (depth == 4) {
        res = max(res, sum)
        return
    }

    for (a in 0..3) {
        val nx = x + dx[a]
        val ny = y + dy[a]

        if (ny !in 0 until n[0] || nx !in 0 until n[1]) continue
        if (visited[ny][nx]) continue

        if (depth == 2) {
            visited[ny][nx] = true
            dfs(x, y, sum + paper[ny][nx], depth + 1)
            visited[ny][nx] = false
        }

        visited[ny][nx] = true
        dfs(nx, ny, sum + paper[ny][nx], depth + 1)
        visited[ny][nx] = false
    }
}