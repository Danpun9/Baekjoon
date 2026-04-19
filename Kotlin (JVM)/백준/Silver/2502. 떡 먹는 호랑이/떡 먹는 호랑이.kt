import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val (d, b) = br.readLine().split(' ').map { it.toInt() }

    var A = 1
    var B = 1

    while (true) {
        val dp = Array(d) { 0 }
        dp[0] = A
        dp[1] = B
        for (i in 2 until d) dp[i] = dp[i - 1] + dp[i - 2]

        if (dp[d - 1] == b) break
        else if (dp[d - 1] < b) B++
        else {
            A++
            B = A
        }
    }

    bw.write("$A\n$B")

    bw.close()
    br.close()
}