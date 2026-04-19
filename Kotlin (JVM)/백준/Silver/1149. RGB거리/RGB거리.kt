import  java.io.*
import kotlin.math.min

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine().toInt()

    val rgb = Array<Array<Int>>(n) { br.readLine().split(" ").map { it.toInt() }.toTypedArray() }

    val dp = Array<Array<Int>>(n) { Array(3) { 0 } }
    dp[0][0] = rgb[0][0]
    dp[0][1] = rgb[0][1]
    dp[0][2] = rgb[0][2]

    val dd = arrayOf(arrayOf(1, 2), arrayOf(0, 2), arrayOf(0, 1))

    for (i in 1 until n) {
        for (j in 0..2) {
            dp[i][j] = min(rgb[i][j] + dp[i - 1][dd[j][0]], rgb[i][j] + dp[i - 1][dd[j][1]])
        }
    }

    var res = min(dp[n - 1][0], dp[n - 1][1])
    res = min(res, dp[n - 1][2])

    bw.write("$res")

    bw.close()
    br.close()
}