import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

lateinit var tree: Array<ArrayList<Int>>
lateinit var visited: Array<Boolean>
lateinit var res: Array<Int>
var cnt = 1

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val (n, m, r) = br.readLine().split(' ').map { it.toInt() }

    tree = Array(n + 1) { ArrayList() }
    visited = Array(n + 1) { false }
    res = Array(n + 1) { 0 }

    repeat(m) {
        val (u, v) = br.readLine().split(' ').map { it.toInt() }
        tree[u].add(v)
        tree[v].add(u)
    }

    for (i in tree) i.sortWith(reverseOrder())

    visited[r] = true
    dfs(r)

    for (i in 1..n) bw.write("${res[i]}\n")

    bw.close()
    br.close()
}

fun dfs(node: Int) {
    res[node] = cnt++

    for (i in tree[node]) {
        if (!visited[i]) {
            visited[i] = true
            dfs(i)
        }
    }
}