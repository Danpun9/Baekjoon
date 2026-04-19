import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    var n = br.readLine().toInt()

    val dp = Array(n + 1) { 0 }
    val tracker = Array(n + 1) { 0 }

    for (i in 2..n) {
        dp[i] = dp[i - 1] + 1
        tracker[i] = i - 1

        if (i % 3 == 0 && dp[i / 3] + 1 < dp[i]) {
            dp[i] = dp[i / 3] + 1
            tracker[i] = i / 3
        }
        if (i % 2 == 0 && dp[i / 2] + 1 < dp[i]) {
            dp[i] = dp[i / 2] + 1
            tracker[i] = i / 2
        }
    }

    bw.write("${dp[n]}\n")

    while (n > 0) {
        bw.write("${n} ")
        n = tracker[n]
    }

    bw.close()
    br.close()
}