import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val (n, k) = br.readLine().split(' ').map { it.toInt() }

    val dp = IntArray(k + 1) { 0 }

    dp[0] = 1

    for (i in 0 until n) {
        val coin = br.readLine().toInt()
        for (j in coin..k) {
            dp[j] += dp[j - coin]
        }
    }

    bw.write("${dp[k]}")

    bw.close()
    br.close()
}