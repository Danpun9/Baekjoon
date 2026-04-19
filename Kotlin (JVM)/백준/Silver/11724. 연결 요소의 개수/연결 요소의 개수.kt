import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

lateinit var graph: Array<ArrayList<Int>>
lateinit var visited: Array<Boolean>

var cnt = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val (n, m) = br.readLine().split(' ').map { it.toInt() }

    visited = Array(n) { false }
    graph = Array(n) { ArrayList<Int>() }

    repeat(m) {
        val (u, v) = br.readLine().split(' ').map { it.toInt() - 1 }

        graph[u].add(v)
        graph[v].add(u)
    }

    for (i in 0 until n) {
        bfs(i)
    }

    bw.write("$cnt")

    bw.close()
    br.close()
}

fun bfs(n: Int) {
    if (visited[n]) return

    cnt++

    val q = ArrayDeque<Int>()

    q.addFirst(n)

    while (q.isNotEmpty()) {
        val curr = q.removeLast()

        for (i in graph[curr]) {
            if (visited[i]) continue

            q.addFirst(i)
            visited[i] = true
        }
    }
}