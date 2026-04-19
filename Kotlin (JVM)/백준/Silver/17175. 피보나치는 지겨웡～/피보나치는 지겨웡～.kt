import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine().toInt()

    val dp = LongArray(51)
    dp[0] = 1
    dp[1] = 1

    for (i in 2..n) {
        dp[i] = (1 + dp[i - 1] + dp[i - 2]) % 1_000_000_007
    }

    bw.write(dp[n].toString())

    bw.close()
    br.close()
}