import java.io.*

lateinit var graph: Array<ArrayList<Int>>
lateinit var visited: Array<Boolean>
lateinit var res: Array<Array<Boolean>>

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine().toInt()

    graph = Array(n) { ArrayList() }

    res = Array(n) { Array(n) { false } }

    for (i in 0 until n) {
        val arr = br.readLine().split(' ').map { it.toInt() }.toTypedArray()
        for (j in 0 until n) if (arr[j] == 1) graph[i].add(j)
    }

    for (i in 0 until n) {
        visited = Array(n) { false }
        dfs(i, i)
    }

    res.forEach { iit ->
        iit.forEach { jit -> bw.write("${if (jit) "1" else "0"} ") }
        bw.write("\n")
    }

    bw.close()
    br.close()
}

fun dfs(v: Int, search: Int) {
    for (i in graph[v]) {
        if (visited[i]) continue
        visited[i] = true
        res[search][i] = true
        dfs(i, search)
    }
}