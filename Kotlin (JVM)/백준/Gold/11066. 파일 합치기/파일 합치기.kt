import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val t = br.readLine().toInt()

    repeat(t) {
        val k = br.readLine().toInt()

        val sum = IntArray(k + 1)
        val dp = Array(k + 1) { IntArray(k + 1) }

        // 누적합 구하기
        val st = br.readLine().split(" ").map { it.toInt() }.toIntArray()
        for (i in 1..k)
            sum[i] = sum[i - 1] + st[i - 1]


        for (dist in 1..k) { // 시작 페이지와 끝 페이지 거리
            for (start in 1..k - dist) { // 시작 페이지
                val end = start + dist // 끝 페이지

                dp[start][end] = Int.MAX_VALUE // 시작 페이지에서 끝 페이지까지 최솟값

                for (mid in start..<end) {
                    dp[start][end] =
                        minOf(dp[start][end], dp[start][mid] + dp[mid + 1][end] + sum[end] - sum[start - 1])
                }
            }
        }

        bw.write("${dp[1][k]}\n")
    }
    
    bw.close()
    br.close()
}