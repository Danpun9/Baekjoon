import java.io.*

var N = 0
var M = 0
var cheeseCnt = 0
lateinit var cheeseMap: Array<IntArray>
lateinit var outAir: Array<BooleanArray>
val removeList = ArrayDeque<Pair<Int, Int>>()

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    N = n
    M = m
    cheeseMap = Array(n) {
        br.readLine().split(" ").map {
            if (it.toInt() == 1) cheeseCnt++
            it.toInt()
        }.toIntArray()
    }

    var res = 0
    while (cheeseCnt > 0) {
        airBFS()
        searchCheese()
        removeCheese()
        res++
    }

    bw.write("$res\n")
    bw.flush()

    bw.close()
    br.close()
}

val dx = intArrayOf(1, -1, 0, 0)
val dy = intArrayOf(0, 0, 1, -1)

fun airBFS() {
    val q = ArrayDeque<Pair<Int, Int>>()
    q.add(Pair(0, 0))
    outAir = Array(N) { BooleanArray(M) }
    outAir[0][0] = true

    while (q.isNotEmpty()) {
        val (y, x) = q.removeLast()
        for (i in 0..3) {
            val ny = y + dy[i]
            val nx = x + dx[i]
            if (ny in 0..<N && nx in 0..<M && !outAir[ny][nx] && cheeseMap[ny][nx] == 0) {
                q.addFirst(Pair(ny, nx))
                outAir[ny][nx] = true
            }
        }
    }
}

fun searchCheese() {
    for (y in 1..<N - 1) {
        for (x in 1..<M - 1) {
            if (cheeseMap[y][x] == 0) continue

            var cnt = 0
            for (i in 0..3) {
                val dy = y + dy[i]
                val dx = x + dx[i]

                if (cheeseMap[dy][dx] == 1) continue
                if (!outAir[dy][dx]) continue

                cnt++
            }

            if (cnt >= 2) removeList.add(Pair(y, x))
        }
    }
}

fun removeCheese() {
    cheeseCnt -= removeList.size
    while (removeList.isNotEmpty()) {
        val (y, x) = removeList.removeLast()
        cheeseMap[y][x] = 0
    }
}