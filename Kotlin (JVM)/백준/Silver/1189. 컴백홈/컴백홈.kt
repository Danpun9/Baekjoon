import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

lateinit var map: Array<Array<Int>>

var R = 0
var C = 0
var K = 0

var cnt = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val st = br.readLine().split(' ').map { it.toInt() }
    R = st[0]
    C = st[1]
    K = st[2]

    map = Array(R) { Array(C) { 0 } }

    for (i in 0 until R) {
        val str = br.readLine()
        for (j in 0 until C) {
            if (str[j] == 'T') map[i][j] = -1
        }
    }

    map[R - 1][0] = 1
    dfs(R - 1, 0)

    bw.write("$cnt")

    bw.close()
    br.close()
}


val dx = arrayOf(1, -1, 0, 0)
val dy = arrayOf(0, 0, 1, -1)

fun dfs(y: Int, x: Int) {
    if (y == 0 && x == C - 1) {
        if (map[y][x] == K) cnt++
        return
    }

    for (i in 0..3) {
        val ny = y + dy[i]
        val nx = x + dx[i]

        if (ny !in 0 until R || nx !in 0 until C) continue

        if (map[ny][nx] == -1 || map[ny][nx] > 0) continue

        map[ny][nx] = map[y][x] + 1
        dfs(ny, nx)
        map[ny][nx] = 0
    }
}
