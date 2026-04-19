import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine().toInt()

    when (n) {
        1 -> bw.write("1")
        2 -> bw.write("2")
        else -> {
            val dp = Array(n + 1) { 0 }
            dp[1] = 1
            dp[2] = 2
            for (i in 3..n) {
                dp[i] = (dp[i - 1] + dp[i - 2]) % 10007
            }
            bw.write("${dp[n]}")
        }
    }

    bw.close()
    br.close()
}