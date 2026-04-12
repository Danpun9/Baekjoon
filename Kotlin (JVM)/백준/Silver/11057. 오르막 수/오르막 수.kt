import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine().toInt()

    val dp = Array(n + 1) { IntArray(10) { 1 } }

    for (i in 2..n) {
        for (j in 0..9) {
            if (j == 0) dp[i][j] = dp[i - 1][0]
            else dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % 10_007
        }
    }

    bw.write("${dp[n].sum() % 10_007}\n")

    bw.close()
    br.close()
}