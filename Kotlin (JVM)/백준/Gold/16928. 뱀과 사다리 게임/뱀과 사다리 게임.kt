import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

val board = HashMap<Int, Int>()
val res = Array(101) { Int.MAX_VALUE }

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val (n, m) = br.readLine().split(' ').map { it.toInt() }

    repeat(n + m) {
        val (x, y) = br.readLine().split(' ').map { it.toInt() }
        board[x] = y
    }

    bfs()

    bw.write("${res[100]}")

    bw.close()
    br.close()
}

fun bfs() {
    val q = ArrayDeque<Pair<Int, Int>>()

    q.addFirst(Pair(1, 0))

    while (q.isNotEmpty()) {
        var (curr, cnt) = q.removeLast()

        if (curr !in 1..100) continue
        if (res[curr] != Int.MAX_VALUE) continue

        res[curr] = cnt
        if (curr == 100) break

        if (board[curr] != null) {
            curr = board[curr]!!
            res[curr] = cnt
        }

        for (i in 1..6) {
            q.addFirst(Pair(curr + i, cnt + 1))
        }
    }
}