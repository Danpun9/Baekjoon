import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

lateinit var tree: Array<ArrayList<Int>>
lateinit var visited: BooleanArray

var delete = -1
var res = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine().toInt()

    tree = Array(n) { ArrayList() }
    visited = BooleanArray(n)

    var root = -1
    val cmd = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    for (i in 0 until n) {
        if (cmd[i] == -1) root = i
        else {
            tree[i].add(cmd[i])
            tree[cmd[i]].add(i)
        }
    }

    delete = br.readLine().toInt()

    if (root == delete) bw.write("0")
    else {
        dfs(root)
        bw.write("$res")
    }
    bw.close()
    br.close()
}

fun dfs(curr: Int) {
    visited[curr] = true

    var cnt = 0

    for (child in tree[curr]) {
        if (visited[child]) continue
        if (child == delete) continue

        cnt++
        dfs(child)
    }

    if (cnt == 0) res++
}