import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val t = br.readLine().toInt()

    val dp = Array(11) { 0 }

    dp[1] = 1
    dp[2] = 2
    dp[3] = 4

    fun dfs(n: Int): Int {
        if (dp[n] != 0) return dp[n]
        dp[n] = dfs(n - 3) + dfs(n - 2) + dfs(n - 1)
        return dp[n]
    }


    for (i in 1..t) {
        val n = br.readLine().toInt()

        bw.write("${dfs(n)}\n")
    }

    bw.close()
    br.close()
}