import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

lateinit var arr: Array<IntArray>
lateinit var dp: Array<IntArray>

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val (m, n) = br.readLine().split(" ").map { it.toInt() }

    arr = Array(m) { br.readLine().split(" ").map { it.toInt() }.toIntArray() }
    dp = Array(m) { IntArray(n) { -1 } }

    bw.write("${dfs(0, 0)}")

    bw.close()
    br.close()
}

val dx = arrayOf(1, -1, 0, 0)
val dy = arrayOf(0, 0, 1, -1)

fun dfs(y: Int, x: Int): Int {
    if (y == arr.size - 1 && x == arr[0].size - 1) return 1

    if (dp[y][x] != -1) return dp[y][x]

    dp[y][x] = 0
    for (i in 0..3) {
        val nx = x + dx[i]
        val ny = y + dy[i]

        if (ny !in arr.indices || nx !in arr[y].indices) continue
        if (arr[ny][nx] >= arr[y][x]) continue

        dp[y][x] += dfs(ny, nx)
    }

    return dp[y][x]
}