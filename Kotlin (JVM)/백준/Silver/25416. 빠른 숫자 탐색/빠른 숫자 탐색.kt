import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

lateinit var map: Array<IntArray>

var res = -1

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    map = Array(5) { br.readLine().split(" ").map { it.toInt() }.toIntArray() }
    val (y, x) = br.readLine().split(" ").map { it.toInt() }

    bfs(y, x)

    bw.write("$res")

    bw.close()
    br.close()
}

fun bfs(y: Int, x: Int) {
    val visited = Array(5) { BooleanArray(5) }

    val q = ArrayDeque<Triple<Int, Int, Int>>()

    q.addFirst(Triple(y, x, 0))

    val dy = arrayOf(1, -1, 0, 0)
    val dx = arrayOf(0, 0, 1, -1)

    while (q.isNotEmpty()) {
        val (cy, cx, cnt) = q.removeLast()

        visited[cy][cx] = true

        if (map[cy][cx] == 1) {
            res = cnt
            return
        }

        for (i in 0..3) {
            val ny = cy + dy[i]
            val nx = cx + dx[i]

            if (ny !in 0..4 || nx !in 0..4) continue
            if (visited[ny][nx]) continue
            if (map[ny][nx] == -1) continue

            q.addFirst(Triple(ny, nx, cnt + 1))
        }
    }
}