import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

lateinit var graph: Array<ArrayList<Int>>
lateinit var visited: BooleanArray
lateinit var dp: Array<IntArray>

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine().toInt()

    graph = Array(n + 1) { ArrayList() }
    visited = BooleanArray(n + 1)
    dp = Array(n + 1) { IntArray(2) }

    repeat(n - 1) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }

        graph[a].add(b)
        graph[b].add(a)
    }

    dfs(1)

    bw.write("${minOf(dp[1][0], dp[1][1])}")

    bw.close()
    br.close()
}

fun dfs(curr: Int) {
    visited[curr] = true

    dp[curr][0] = 0
    dp[curr][1] = 1

    for (next in graph[curr]) {
        if (visited[next]) continue

        dfs(next)
        dp[curr][0] += dp[next][1]
        dp[curr][1] += minOf(dp[next][0], dp[next][1])
    }
}