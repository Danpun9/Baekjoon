import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

lateinit var tree: Array<ArrayList<Pair<Int, Int>>>
lateinit var visited: BooleanArray

var start = 0
var res = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine().toInt()

    tree = Array(n + 1) { ArrayList() }
    visited = BooleanArray(n + 1)

    repeat(n - 1) {
        val (a, b, w) = br.readLine().split(" ").map { it.toInt() }

        tree[a].add(Pair(b, w))
        tree[b].add(Pair(a, w))
    }

    dfs(1, 0)

    res = 0
    visited = BooleanArray(n + 1)

    dfs(start, 0)

    bw.write("$res")

    bw.close()
    br.close()
}

fun dfs(curr: Int, len: Int) {
    if (visited[curr]) return

    visited[curr] = true
    if (len > res) {
        start = curr
        res = len
    }

    for (next in tree[curr]) {
        val (next_node, next_w) = next
        dfs(next_node, next_w + len)
    }
}