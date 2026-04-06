import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    lateinit var st: StringTokenizer

    st = StringTokenizer(br.readLine())

    val n = st.nextToken().toInt()
    val k = st.nextToken().toInt()

    val dp = Array(k + 1) { LongArray(n + 1) }
    val mod = 1000000000L

    for (i in 0..n) {
        dp[1][i] = 1
    }

    for (i in 1..k) {
        dp[i][0] = 1
    }

    for (i in 2..k) {
        for (j in 1..n) {
            dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % mod
        }
    }

    bw.write("${dp[k][n]}")

    bw.close()
    br.close()
}