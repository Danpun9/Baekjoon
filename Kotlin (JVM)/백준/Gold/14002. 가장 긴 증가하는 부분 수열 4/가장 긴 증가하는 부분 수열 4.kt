import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()
    val arr = br.readLine().split(" ").map { it.toInt() }.toIntArray()

    val dp = IntArray(n) { 1 }
    var res = 1

    for (i in 1..<n) {
        for (j in 0..<i) {
            if (arr[i] <= arr[j]) continue

            dp[i] = maxOf(dp[i], dp[j] + 1)
            res = maxOf(res, dp[i])

        }
    }

    bw.write("$res\n")

    val s = ArrayDeque<Int>()
    for (i in n - 1 downTo 0) {
        if (dp[i] != res) continue

        s.addFirst(arr[i])
        res--
    }

    while (s.isNotEmpty()) bw.write("${s.removeFirst()} ")

    bw.close()
    br.close()
}