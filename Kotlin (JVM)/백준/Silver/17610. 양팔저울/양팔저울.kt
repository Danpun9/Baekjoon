import java.io.*

lateinit var weight: Array<Int>
lateinit var visited: Array<Boolean>
var k = 0


fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val br = BufferedReader(InputStreamReader(System.`in`))

    k = br.readLine().toInt()

    weight = br.readLine().split(' ').map { it.toInt() }.toTypedArray()

    visited = Array(weight.sumOf { it }) { false }

    dfs(0, 0)
    
    var res = 0
    for (i in visited) {
        if (!i) res++
    }

    bw.write("$res")

    bw.close()
    br.close()
}

fun dfs(sum: Int, depth: Int) {
    if (depth == k) {
        if (sum >= 1) visited[sum - 1] = true
        return
    }

    dfs(sum, depth + 1)
    dfs(sum + weight[depth], depth + 1)
    dfs(sum - weight[depth], depth + 1)
}