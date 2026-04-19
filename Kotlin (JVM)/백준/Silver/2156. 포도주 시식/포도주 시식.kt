import java.io.*
import kotlin.math.max

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine().toInt()

    val glass = Array(n + 1) { 0 }
    repeat(n) {
        glass[it + 1] = br.readLine().toInt()
    }

    val dp = Array(n + 1) { 0 }
    dp[1] = glass[1]

    if (n != 1) {
        dp[2] = glass[1] + glass[2]
        
        for (i in 3..n) {
            dp[i] = max(dp[i - 3] + glass[i - 1] + glass[i], dp[i - 2] + glass[i])
            dp[i] = max(dp[i - 1], dp[i])
        }

        dp.sort()
    }

    bw.write("${dp[n].toInt()}")

    bw.close()
    br.close()
}