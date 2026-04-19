import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

lateinit var graph: Array<ArrayList<Int>>
lateinit var visited: Array<Boolean>
lateinit var res: Array<Int>
var cnt = 1

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val (n, m, r) = br.readLine().split(' ').map { it.toInt() }

    graph = Array(n + 1) { ArrayList() }
    visited = Array(n + 1) { false }
    res = Array(n + 1) { 0 }

    repeat(m) {
        val (u, v) = br.readLine().split(' ').map { it.toInt() }
        graph[u].add(v)
        graph[v].add(u)
    }

    for (i in graph) i.sortWith(reverseOrder())

    bfs(r)

    for (i in 1..n) bw.write("${res[i]}\n")

    bw.close()
    br.close()
}

fun bfs(root: Int) {
    val q = ArrayDeque<Int>()

    q.addFirst(root)

    while (q.isNotEmpty()) {
        val idx = q.removeLast()
        if (visited[idx]) continue

        visited[idx] = true
        res[idx] = cnt++

        for (i in graph[idx]) {
            if (!visited[i]) q.addFirst(i)
        }
    }
}
