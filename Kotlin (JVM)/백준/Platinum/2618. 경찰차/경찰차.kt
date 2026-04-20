import java.io.*
import kotlin.math.abs

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine().toInt()
    val w = br.readLine().toInt()

    val eventR = IntArray(w + 1)
    val eventC = IntArray(w + 1)

    for (i in 1..w) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        eventR[i] = a
        eventC[i] = b
    }

    // p1: 경찰차1이 마지막으로 처리한 사건 번호
    // dp[p1][p2]: 앞으로 남은 사건들을 처리하기 위해 이동해야 하는 거리
    val dp = Array(w + 1) { IntArray(w + 1) { -1 } }

    fun getDist(carType: Int, prevE: Int, nextE: Int): Int {
        val r1: Int
        val c1: Int

        if (prevE == 0) {
            if (carType == 1) {
                r1 = 1
                c1 = 1
            } else {
                r1 = n
                c1 = n
            }
        } else {
            r1 = eventR[prevE]
            c1 = eventC[prevE]
        }

        val r2 = eventR[nextE]
        val c2 = eventC[nextE]

        return abs(r1 - r2) + abs(c1 - c2)
    }

    fun dfs(p1: Int, p2: Int): Int {
        val next = maxOf(p1, p2) + 1

        if (next > w) return 0

        if (dp[p1][p2] != -1) return dp[p1][p2]

        val cost1 = dfs(next, p2) + getDist(1, p1, next)
        val cost2 = dfs(p1, next) + getDist(2, p2, next)

        dp[p1][p2] = minOf(cost1, cost2)
        return dp[p1][p2]
    }

    val totalDist = dfs(0, 0)
    bw.write("$totalDist\n")

    var p1 = 0
    var p2 = 0
    for (i in 1..w) {
        val next = maxOf(p1, p2) + 1
        val cost1 = dfs(next, p2) + getDist(1, p1, next)
        val cost2 = dfs(p1, next) + getDist(2, p2, next)

        if (cost1 < cost2) {
            bw.write("1\n")
            p1 = next
        } else {
            bw.write("2\n")
            p2 = next
        }
    }
    bw.flush()

    bw.close()
    br.close()
}
