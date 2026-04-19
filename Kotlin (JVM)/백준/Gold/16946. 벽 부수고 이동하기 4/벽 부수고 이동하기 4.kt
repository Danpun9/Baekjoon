import java.io.*

lateinit var map: Array<IntArray>
lateinit var groupMap: Array<IntArray>
val group = ArrayList<Int>()

var N = 0
var M = 0


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    N = n
    M = m

    map = Array(n) { br.readLine().map { it - '0' }.toIntArray() }
    groupMap = Array(n) { IntArray(m) }

    for (i in 0 until n) {
        for (j in 0 until m) {
            if (map[i][j] == 0 && groupMap[i][j] == 0) bfs(i, j)
        }
    }

    for (i in 0 until n) {
        for (j in 0 until m) {
            if (map[i][j] == 0) bw.write("0")
            else bw.write("${checkWall(i, j)}")
        }
        bw.write("\n")
    }

    bw.close()
    br.close()
}

val dx = arrayOf(1, -1, 0, 0)
val dy = arrayOf(0, 0, 1, -1)

fun bfs(y: Int, x: Int) {
    group.add(0)

    val q = ArrayDeque<Pair<Int, Int>>()

    groupMap[y][x] = group.size
    q.addFirst(Pair(y, x))

    while (q.isNotEmpty()) {
        val (cy, cx) = q.removeLast()
        group[group.size - 1]++

        for (i in 0..3) {
            val ny = cy + dy[i]
            val nx = cx + dx[i]

            if (ny !in 0 until N || nx !in 0 until M) continue
            if (map[ny][nx] == 1) continue
            if (groupMap[ny][nx] != 0) continue

            groupMap[ny][nx] = group.size
            q.addFirst(Pair(ny, nx))
        }
    }
}

fun checkWall(y: Int, x: Int): Int {
    val check = mutableSetOf<Int>()

    var res = 1

    for (i in 0..3) {
        val ny = y + dy[i]
        val nx = x + dx[i]

        if (ny !in 0 until N || nx !in 0 until M) continue
        if (map[ny][nx] == 1) continue
        if (check.contains(groupMap[ny][nx])) continue

        res += group[groupMap[ny][nx] - 1]
        check.add(groupMap[ny][nx])
    }

    return res % 10
}

