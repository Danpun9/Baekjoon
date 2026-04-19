import java.io.*

lateinit var graph: Array<ArrayList<Int>>
lateinit var res: Array<Int>
var cnt = 1

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (n, m, r) = br.readLine().split(' ').map { it.toInt() }

    graph = Array(n) { ArrayList() }
    res = Array(n) { 0 }

    repeat(m) {
        val (s, e) = br.readLine().split(' ').map { it.toInt() - 1 }
        graph[s].add(e)
        graph[e].add(s)
    }

    for (i in graph) i.sort()

    dfs(r - 1)

    res.forEach { bw.write("$it\n") }

    bw.close()
    br.close()
}

fun dfs(curr: Int) {
    res[curr] = cnt++

    for (i in graph[curr]) {
        if (res[i] == 0) dfs(i)
    }
}