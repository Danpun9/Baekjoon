import java.io.*
import kotlin.math.max

val alphabet = BooleanArray(26)
lateinit var map: Array<CharArray>

val dx = arrayOf(1, -1, 0, 0)
val dy = arrayOf(0, 0, 1, -1)

var res = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val (r, c) = br.readLine().split(" ").map { it.toInt() }

    map = Array(r) { CharArray(c) }
    for (i in 0 until r) {
        val str = br.readLine()
        for (j in 0 until c) {
            map[i][j] = str[j]
        }
    }

    alphabet[map[0][0] - 'A'] = true
    dfs(0, 0, 1)

    bw.write("$res")

    bw.close()
    br.close()
}

fun dfs(x: Int, y: Int, score: Int) {
    res = max(res, score)

    for (i in 0..3) {
        val nx = x + dx[i]
        val ny = y + dy[i]

        if (!inRannge(nx, ny)) continue
        if (alphabet[map[nx][ny] - 'A']) continue

        alphabet[map[nx][ny] - 'A'] = true
        dfs(nx, ny, score + 1)
        alphabet[map[nx][ny] - 'A'] = false
    }
}

fun inRannge(x: Int, y: Int): Boolean {
    if (x in 0 until map.size && y in 0 until map[0].size) return true
    else return false
}