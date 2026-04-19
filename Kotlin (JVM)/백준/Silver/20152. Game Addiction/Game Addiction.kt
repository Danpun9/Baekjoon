import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val (h, n) = br.readLine().split(" ").map { it.toInt() }

    val d = Math.abs(n - h)

    val dp = Array(d + 1) { LongArray(d + 1) { 1 } }

    for (x in 1..d) {
        for (y in 1 until x) {
            dp[x][y] = dp[x - 1][y] + dp[x][y - 1]
        }
        dp[x][x] = dp[x][x - 1]
    }

    bw.write("${dp[d][d]}\n")

    bw.close()
    br.close()
}