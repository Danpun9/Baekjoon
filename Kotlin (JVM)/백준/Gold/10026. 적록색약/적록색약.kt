import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

lateinit var map: Array<IntArray>
lateinit var visited: Array<BooleanArray>
var n = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    n = br.readLine().toInt()

    map = Array(n) {
        br.readLine().map {
            when (it) {
                'R' -> 1
                'G' -> 2
                else -> 3
            }
        }.toIntArray()
    }
    visited = Array(n) { BooleanArray(n) }
    var res = 0

    for (i in 0 until n) {
        for (j in 0 until n) {
            if (visited[i][j]) continue

            dfs(i, j)
            res++
        }
    }

    bw.write("$res ")

    for (i in 0 until n) {
        for (j in 0 until n) {
            if (map[i][j] == 1) map[i][j] = 2
        }
    }

    visited = Array(n) { BooleanArray(n) }
    res = 0

    for (i in 0 until n) {
        for (j in 0 until n) {
            if (visited[i][j]) continue

            dfs(i, j)
            res++
        }
    }

    bw.write("$res")

    bw.close()
    br.close()
}

val dy = arrayOf(1, -1, 0, 0)
val dx = arrayOf(0, 0, 1, -1)

fun dfs(y: Int, x: Int) {
    visited[y][x] = true

    for (i in 0..3) {
        val ny = y + dy[i]
        val nx = x + dx[i]

        if (ny !in 0..<n || nx !in 0..<n) continue
        if (visited[ny][nx]) continue
        if (map[ny][nx] != map[y][x]) continue

        dfs(ny, nx)
    }
}