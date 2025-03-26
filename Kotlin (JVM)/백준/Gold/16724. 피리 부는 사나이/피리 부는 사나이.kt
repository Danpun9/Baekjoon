import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

lateinit var map: Array<CharArray>
lateinit var visited: Array<IntArray>
var res = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    map = Array(n) { br.readLine().toCharArray() }
    visited = Array(n) { IntArray(m) }

    for (i in 0..<n)
        for (j in 0..<m)
            if (visited[i][j] == 0) dfs(i, j)
    
    bw.write("$res")

    bw.close()
    br.close()
}

fun dfs(y: Int, x: Int) {
    visited[y][x] = 1

    val (ny, nx) = when (map[y][x]) {
        'D' -> Pair(y + 1, x)
        'U' -> Pair(y - 1, x)
        'R' -> Pair(y, x + 1)
        else -> Pair(y, x - 1)
    }

    if (visited[ny][nx] == 1) res++
    if (visited[ny][nx] == 0) dfs(ny, nx)
    visited[y][x] = 2
}