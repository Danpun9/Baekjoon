import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.max

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val (n, m) = br.readLine().split(' ').map { it.toInt() }
    val str1 = br.readLine()
    val str2 = br.readLine()

    val dp = Array(m) { Array(n) { 0 } }

    for (i in 0 until n) {
        if (str1[i] == str2[0]) dp[0][i] = 1
    }

    for (j in 1 until m) {
        for (i in 0 until n) {

            when (i) {
                0 -> dp[j][i] = dp[j - 1][i + 1]
                n - 1 -> dp[j][i] = dp[j - 1][i - 1]
                else -> dp[j][i] = max(dp[j - 1][i + 1], dp[j - 1][i - 1])
            }
            if (str1[i] == str2[j]) dp[j][i]++
        }
    }

    dp[m - 1].sort()

    bw.write("${dp[m - 1][n - 1]}")

    bw.close()
    br.close()
}

