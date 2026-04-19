import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine().toInt()

    val dp = Array(if (n < 4) 4 else n + 1) { 0 }
    dp[1] = 1
    dp[2] = 1
    dp[3] = 2

    for (i in 4..n) dp[i] = (dp[i - 3] + dp[i - 1]) % 1_000_000_009

    bw.write("${dp[n]}")


    bw.close()
    br.close()
}