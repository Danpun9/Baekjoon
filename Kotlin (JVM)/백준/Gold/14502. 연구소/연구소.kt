import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

var res = 0
lateinit var map: Array<IntArray>

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    map = Array(n) { br.readLine().split(" ").map { it.toInt() }.toIntArray() }

    buildWall(0)

    bw.write("$res\n")

    bw.close()
    br.close()
}

// 벽 배치
fun buildWall(depth: Int) {
    if (depth == 3) {
        res = maxOf(res, spreadVirus())
        return
    }

    for (i in map.indices) {
        for (j in map[0].indices) {
            if (map[i][j] != 0) continue

            map[i][j] = 1
            buildWall(depth + 1)
            map[i][j] = 0
        }
    }
}

val dy = arrayOf(1, -1, 0, 0)
val dx = arrayOf(0, 0, 1, -1)

// 바이러스 시뮬
fun spreadVirus(): Int {
    val q = ArrayDeque<Pair<Int, Int>>()
    val copy = Array(map.size) { map[it].copyOf() }
    val visited = Array(map.size) { BooleanArray(map[0].size) }

    for (i in copy.indices)
        for (j in copy[0].indices)
            if (copy[i][j] == 2) q.addFirst(Pair(i, j))

    while (q.isNotEmpty()) {
        val (y, x) = q.removeLast()
        visited[y][x] = true
        copy[y][x] = 2

        for (i in 0..3) {
            val ny = y + dy[i]
            val nx = x + dx[i]

            if (ny !in map.indices || nx !in map[0].indices) continue
            if (copy[ny][nx] != 0) continue
            if (visited[ny][nx]) continue

            q.addFirst(Pair(ny, nx))
        }
    }

    // 바이러스 퍼진 후 결과
    var ret = 0
    for (i in map.indices)
        for (j in map[0].indices)
            if (copy[i][j] == 0) ret++

    return ret
}