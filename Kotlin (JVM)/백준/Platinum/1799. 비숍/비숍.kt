import java.io.*
import kotlin.math.max

lateinit var board: Array<BooleanArray>
lateinit var placeBoard: Array<BooleanArray>
var N = 0

var res1 = 0
var res2 = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine().toInt()
    N = n

    board = Array(n) { br.readLine().split(" ").map { it == "1" }.toBooleanArray() }
    placeBoard = Array(n) { BooleanArray(n) }

    dfs(0, 0, 0, false)
    dfs(0, 1, 0, true)

    bw.write("${res1 + res2}")

    bw.close()
    br.close()
}

fun dfs(y: Int, x: Int, cnt: Int, color: Boolean) {
    if (y >= N) {
        if (color)
            res1 = max(res1, cnt)
        else
            res2 = max(res2, cnt)
        return
    }

    if (x >= N) {
        if (color) dfs(y + 1, if ((y + 1) % 2 == 0) 1 else 0, cnt, color)
        else dfs(y + 1, if ((y + 1) % 2 == 1) 1 else 0, cnt, color)
        return
    }

    if (!board[y][x]) {
        dfs(y, x + 2, cnt, color)
        return
    }

    if (checkBishop(y, x)) {
        placeBoard[y][x] = true
        dfs(y, x + 2, cnt + 1, color)
        placeBoard[y][x] = false
    }

    dfs(y, x + 2, cnt, color)

}


fun checkBishop(y: Int, x: Int): Boolean {
    var yy = y - 1
    var xx = x - 1

    while (yy >= 0 && xx >= 0) {
        if (placeBoard[yy--][xx--]) return false
    }

    yy = y - 1
    xx = x + 1
    while (yy >= 0 && xx < N) {
        if (placeBoard[yy--][xx++]) return false
    }

    return true
}