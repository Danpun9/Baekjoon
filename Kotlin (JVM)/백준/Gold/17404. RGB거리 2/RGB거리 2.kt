import  java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine().toInt()

    val rgb = Array(n) { br.readLine().split(" ").map { it.toInt() }.toIntArray() }

    val dp = Array(n + 1) { IntArray(3) { 0 } }

    var res = Int.MAX_VALUE

    for (firstHouseColor in 0..<3) {
        for (j in 0..<3) dp[0][j] = if (j == firstHouseColor) rgb[0][j] else 1000 * 1000 + 1

        for (j in 1 until n) {
            dp[j][0] = minOf(dp[j - 1][1], dp[j - 1][2]) + rgb[j][0]
            dp[j][1] = minOf(dp[j - 1][0], dp[j - 1][2]) + rgb[j][1]
            dp[j][2] = minOf(dp[j - 1][0], dp[j - 1][1]) + rgb[j][2]
        }

        for (j in 0..<3) if (j != firstHouseColor) res = minOf(res, dp[n - 1][j])
    }

    bw.write("$res")

    bw.close()
    br.close()
}