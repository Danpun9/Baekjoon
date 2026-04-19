import java.io.*
import kotlin.math.max

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val t = br.readLine().toInt()

    for (i in 1..t) {
        val n = br.readLine().toInt()

        val arr = Array<Array<Int>>(2) { br.readLine().split(" ").map { it.toInt() }.toTypedArray() }

        if (n == 1) {
            bw.write("${max(arr[0][0], arr[1][0])}\n")
            continue
        }

        val dp = Array<Array<Int>>(2) { Array(n) { 0 } }

        dp[0][0] = arr[0][0]
        dp[1][0] = arr[1][0]

        dp[0][1] = dp[1][0] + arr[0][1]
        dp[1][1] = dp[0][0] + arr[1][1]

        for (j in 2 until n) {
            dp[0][j] = arr[0][j] + max(dp[1][j - 1], dp[1][j - 2])
            dp[1][j] = arr[1][j] + max(dp[0][j - 1], dp[0][j - 2])
        }

        bw.write("${max(dp[0][n - 1], dp[1][n - 1])}\n")
    }

    bw.close()
    br.close()
}