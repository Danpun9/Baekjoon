import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine().toInt()
    val p = br.readLine().split(" ").map { it.toInt() }.toIntArray()

    val dp = IntArray(n + 1)

    for (i in 1..n)
        for (j in 1..i)
            dp[i] = maxOf(dp[i], p[j - 1] + dp[i - j])

    bw.write("${dp[n]}\n")

    bw.close()
    br.close()
}