import java.io.*

lateinit var tree: Array<ArrayList<Int>>
lateinit var res: Array<Int>

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val (n, r, q) = br.readLine().split(" ").map { it.toInt() }

    tree = Array(n) { ArrayList() }

    repeat(n - 1) {
        val (s, e) = br.readLine().split(' ').map { it.toInt() }
        tree[s - 1].add(e - 1)
        tree[e - 1].add(s - 1)
    }

    res = Array(n) { 0 }

    dfs(r - 1, -1)

    repeat(q) {
        val query = br.readLine().toInt() - 1
        bw.write("${res[query]}\n")
    }

    bw.close()
    br.close()
}

fun dfs(node: Int, parent: Int) {
    res[node] = 1

    for (i in tree[node]) {
        if (i != parent) {
            dfs(i, node)
            res[node] += res[i]
        }
    }
}