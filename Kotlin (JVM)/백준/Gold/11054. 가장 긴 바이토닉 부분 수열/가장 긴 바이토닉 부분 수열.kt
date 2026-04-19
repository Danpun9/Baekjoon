import java.io.*
import kotlin.math.max

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine().toInt()

    val arr = br.readLine().split(" ").map { it.toInt() }

    val dp = Array(2) { Array(n) { 1 } }

    for (i in 0 until n) {
        for (j in 0 until i) {
            if (arr[i] > arr[j]) dp[0][i] = max(dp[0][i], dp[0][j] + 1)
        }
    }

    for (i in n - 1 downTo 0) {
        for (j in n - 1 downTo i) {
            if (arr[i] > arr[j]) dp[1][i] = max(dp[1][i], dp[1][j] + 1)
        }
    }

    var res = 0
    for (i in 0 until n) {
        res = max(res, dp[0][i] + dp[1][i] - 1)
    }

    bw.write("$res")

    bw.close()
    br.close()
}