import java.io.*

lateinit var graph: Array<ArrayList<Int>>
lateinit var visited: Array<Boolean>

var res = 0L
var cnt = 1L

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (n, m, r) = br.readLine().split(' ').map { it.toInt() }

    graph = Array(n + 1) { ArrayList() }
    visited = Array(n + 1) { false }

    repeat(m) {
        val (u, v) = br.readLine().split(' ').map { it.toInt() }
        graph[u].add(v)
        graph[v].add(u)
    }

    for (i in graph) i.sort()

    visited[r] = true
    dfs(r, 0)

    bw.write("$res")

    bw.close()
    br.close()
}

fun dfs(n: Int, depth: Long) {
    res += depth * cnt++

    for (i in graph[n]) {
        if (!visited[i]) {
            visited[i] = true
            dfs(i, depth + 1)
        }
    }
}