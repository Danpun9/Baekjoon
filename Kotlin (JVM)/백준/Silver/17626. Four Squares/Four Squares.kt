import java.io.*
import kotlin.math.min

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine().toInt()

    val dp = IntArray(n + 1) { Int.MAX_VALUE }
    dp[0] = 0
    dp[1] = 1

    for (i in 2..n) {
        for (j in 1 until i) {
            if (j * j > i) break
            dp[i] = min(dp[i], dp[i - j * j] + 1)
        }
    }

    bw.write(dp[n].toString())

    bw.close()
    br.close()
}
