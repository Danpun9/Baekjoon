import java.io.*

lateinit var board: Array<Int>

var res = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine().toInt()
    board = Array(n) { 0 }

    dfs(0)

    bw.write("$res")

    bw.close()
    br.close()
}

fun dfs(col: Int) {
    if (col == board.size) {
        res++
        return
    }

    for (i in 0 until board.size) {
        board[col] = i

        if (isPossible(col)) {
            dfs(col + 1)
        }
    }
}

fun isPossible(col: Int): Boolean {
    for (i in 0 until col) {
        if (board[i] == board[col]) return false
        if (Math.abs(col - i) == Math.abs(board[col] - board[i])) return false
    }

    return true
}