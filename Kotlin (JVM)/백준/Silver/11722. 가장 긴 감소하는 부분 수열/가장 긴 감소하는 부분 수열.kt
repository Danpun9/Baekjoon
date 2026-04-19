import java.io.*
import kotlin.math.max

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine().toInt()

    val arr = br.readLine().split(" ").map { it.toInt() }.toTypedArray()

    val dp = Array(n) { 1 }

    for (i in 0 until n) {
        for (j in 0 until i) {
            if (arr[i] < arr[j]) dp[i] = max(dp[i], dp[j] + 1)
        }
    }

    dp.sort()

    bw.write("${dp[n - 1]}")

    bw.close()
    br.close()
}