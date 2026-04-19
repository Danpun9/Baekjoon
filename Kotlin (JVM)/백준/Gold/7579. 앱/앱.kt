import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.max
import kotlin.math.min

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val (N, M) = br.readLine().split(' ').map { it.toInt() }

    val m = br.readLine().split(' ').map { it.toInt() }.toIntArray()
    val c = br.readLine().split(' ').map { it.toInt() }.toIntArray()

    val dp = Array(N) { IntArray(10001) }
    var res = Int.MAX_VALUE

    for (i in 0 until N) {
        for (j in 0 until 10001) {
            if (i == 0) {
                if (j >= c[i]) dp[i][j] = m[i]
            } else {
                if (j >= c[i])
                    dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - c[i]] + m[i])
                else
                    dp[i][j] = dp[i - 1][j]
            }

            if (dp[i][j] >= M) res = min(res, j)
        }
    }

    bw.write("$res")

    bw.close()
    br.close()
}
