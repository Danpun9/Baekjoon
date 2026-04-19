import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine().toInt()

    val dp = Array<Array<Long>>(n + 1) { Array(10) { 0 } }

    for (i in 1..9) dp[1][i] = 1

    for (i in 2..n) {
        dp[i][0] = dp[i - 1][1] % 1_000_000_000
        for (j in 1..8) dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % 1_000_000_000
        dp[i][9] = dp[i - 1][8] % 1_000_000_000
    }

    var res = 0L

    repeat(10) { res += dp[n][it] }

    bw.write("${res % 1_000_000_000}")

    bw.close()
    br.close()
}