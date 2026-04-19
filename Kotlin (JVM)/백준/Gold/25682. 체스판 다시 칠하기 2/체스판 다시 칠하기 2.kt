import java.io.*
import kotlin.math.*


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val (n, m, k) = br.readLine().split(' ').map { it.toInt() }

    val board = Array(n + 1) { Array(m + 1) { 0 } }

    for (i in 1..n) {
        var isBlack = if (i % 2 == 0) true else false
        val str = br.readLine()
        for (j in 1..m) {
            board[i][j] =
                board[i - 1][j] + board[i][j - 1] - board[i - 1][j - 1] + if (isBlack && str[j - 1] == 'W' || !isBlack && str[j - 1] == 'B') 1 else 0
            isBlack = !isBlack
        }
    }

    var max = Int.MIN_VALUE
    var min = Int.MAX_VALUE
    for (i in k..n) {
        for (j in k..m) {
            val cnt = board[i][j] - board[i - k][j] - board[i][j - k] + board[i - k][j - k]
            max = max(cnt, max)
            min = min(cnt, min)
        }
    }

    bw.write("${min(min, k * k - max)}")

    bw.close()
    br.close()
}