import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

lateinit var graph: Array<ArrayList<Int>>
lateinit var color: Array<Boolean?>

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val t = br.readLine().toInt()

    repeat(t) {
        val (v, e) = br.readLine().split(' ').map { it.toInt() }

        graph = Array(v + 1) { ArrayList() }
        color = Array(v + 1) { null }

        repeat(e) {
            val (start, end) = br.readLine().split(' ').map { it.toInt() }
            graph[start].add(end)
            graph[end].add(start)
        }

        var res = true
        for (i in 0 until v) {
            if (!bfs(i)) {
                res = false
                break
            }
        }

        bw.write(if (res) "YES\n" else "NO\n")

    }


    bw.close()
    br.close()
}

fun bfs(idx: Int): Boolean {
    if (color[idx] != null) return true

    val q = ArrayDeque<Pair<Int, Boolean>>()

    q.addFirst(Pair(idx, false))

    while (q.isNotEmpty()) {
        val (curr, prevColor) = q.removeLast()

        color[curr] = !prevColor

        for (i in graph[curr]) {
            if (color[i] == null) q.addFirst(Pair(i, color[curr]!!))
            else {
                if (color[i] != color[curr]!!) continue
                else return false
            }
        }
    }

    return true
}