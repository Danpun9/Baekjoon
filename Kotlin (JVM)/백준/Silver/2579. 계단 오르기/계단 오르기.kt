import java.io.*
import kotlin.math.max

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine().toInt()
    val arr = Array(n) { br.readLine().toInt() }

    val dp = Array(2) { Array(n + 1) { 0 } }

    dp[0][1] = arr[0] // 이전 계단 선택 o
    dp[1][1] = arr[0] // 이전 계단 선택 x

    for (i in 2..n) {
        dp[0][i] = dp[1][i - 1] + arr[i - 1]
        dp[1][i] = max(dp[0][i - 2], dp[1][i - 2]) + arr[i - 1]
    }

    bw.write("${max(dp[0][n], dp[1][n])}")

    bw.close()
    br.close()
}