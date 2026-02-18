import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine().toInt()
    val health = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    val happy = br.readLine().split(" ").map { it.toInt() }.toIntArray()

    val dp = Array(n + 1) { IntArray(100) }

    for (i in 1..n) {
        for (j in 0..<100) {
            dp[i][j] = dp[i - 1][j]

            if (j >= health[i - 1])
                dp[i][j] = maxOf(dp[i][j], dp[i - 1][j - health[i - 1]] + happy[i - 1])
        }
    }

    bw.write("${dp[n][99]}\n")

    bw.close()
    br.close()
}
