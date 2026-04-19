import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

lateinit var board: Array<Array<Int>>

val dx = arrayOf(1, 2, 2, 1, -1, -2, -2, -1)
val dy = arrayOf(2, 1, -1, -2, -2, -1, 1, 2)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val t = br.readLine().toInt()

    repeat(t) {
        val i = br.readLine().toInt()
        board = Array(i) { Array(i) { 0 } }

        val start = br.readLine().split(' ').map { it.toInt() }
        val end = br.readLine().split(' ').map { it.toInt() }

        bfs(start, end)

        bw.write("${board[end[0]][end[1]]}\n")
    }

    bw.close()
    br.close()
}

fun bfs(start: List<Int>, end: List<Int>) {
    if (start[0] == end[0] && start[1] == end[1]) return

    val q = ArrayDeque<Triple<Int, Int, Int>>()

    q.addFirst(Triple(start[0], start[1], 0))

    while (q.isNotEmpty()) {
        val (x, y, depth) = q.removeLast()

        for (i in 0..7) {
            val nx = x + dx[i]
            val ny = y + dy[i]

            if (nx < 0 || nx >= board.size || ny < 0 || ny >= board.size) continue
            if (nx == end[0] && ny == end[1]) {
                board[nx][ny] = depth + 1
                return
            } else if (board[nx][ny] == 0) {
                board[nx][ny] = depth + 1
                q.addFirst(Triple(nx, ny, depth + 1))
            }
        }
    }
}