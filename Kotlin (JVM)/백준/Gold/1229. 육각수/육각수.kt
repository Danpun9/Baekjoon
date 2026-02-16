import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine().toInt()

    val hexagonal = mutableListOf<Int>()
    var i = 1
    while (true) {
        val h = i * (2 * i - 1)
        if (h > n) break
        hexagonal.add(h)
        i++
    }

    val dp = IntArray(n + 1) { 6 }
    dp[0] = 0

    for (h in hexagonal) {
        for (j in h..n) {
            dp[j] = minOf(dp[j], dp[j - h] + 1)
        }
    }

    bw.write("${dp[n]}\n")

    bw.close()
    br.close()
}
