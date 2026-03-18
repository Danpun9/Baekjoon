import java.io.*
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    while (true) {
        var st = StringTokenizer(br.readLine())

        // 정보 입력
        val n = st.nextToken().toInt()
        if (n == 0) break
        val s = st.nextToken().toInt()
        val t = st.nextToken().toInt()

        // 보드 입력
        val board = IntArray(n + 2) // 시작점, 보드 칸 도착점
        var idx = 1
        while (idx <= n) {
            st = StringTokenizer(br.readLine())
            while (st.hasMoreTokens())
                board[idx++] = st.nextToken().toInt()
        }

        // dp[i][j]: i번째 턴, j위치에서의 수익
        val dp = Array(t + 1) { IntArray(n + 2) { Int.MIN_VALUE } }

        dp[0][0] = 0 // 시작점

        for (turn in 1..t) {
            for (i in 1..n + 1) {
                for (k in 1..s) {
                    val prev = i - k
                    if (prev < 0) continue
                    if (dp[turn - 1][prev] == Int.MIN_VALUE) continue
                    dp[turn][i] = maxOf(dp[turn][i], dp[turn - 1][prev] + board[i])
                }
            }
        }

        var res = Int.MIN_VALUE
        dp.forEach { res = maxOf(res, it[n + 1]) }

        bw.write("$res\n")
    }

    bw.close()
    br.close()
}