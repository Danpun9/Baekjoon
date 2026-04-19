import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

lateinit var map: Array<CharArray>
var breakdown = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    var y = 0
    var x = 0

    map = Array(n) { CharArray(m) }

    for (i in 0 until n) {
        val str = br.readLine()
        for (j in 0 until m) {
            if (str[j] == '@') {
                y = i
                x = j
            }

            map[i][j] = str[j]
        }
    }
    dfs(y, x)

    bw.write("$breakdown ${check()}")

    bw.close()
    br.close()
}

val dy = arrayOf(1, -1, 0, 0)
val dx = arrayOf(0, 0, 1, -1)

fun dfs(y: Int, x: Int) {
    when (map[y][x]) {
        '.', '|' -> return

        '#' -> {
            map[y][x] = '*'
            return
        }

        '*' -> {
            map[y][x] = '.'
            breakdown++

            for (i in 0..3) {
                val ny = y + dy[i]
                val nx = x + dx[i]

                if (ny !in 0..<map.size || nx !in 0..<map[0].size) continue

                dfs(ny, nx)
            }
        }

        '@' -> {
            map[y][x] = '.'

            for (i in 0..3) {
                for (j in 1..2) {
                    val ny = y + dy[i] * j
                    val nx = x + dx[i] * j

                    if (ny !in 0..<map.size || nx !in 0..<map[0].size) continue
                    if (map[ny][nx] == '|') break

                    dfs(ny, nx)
                }
            }
        }
    }
}

fun check(): Int {
    var res = 0

    map.forEach {
        it.forEach { c ->
            if (c == '#' || c == '*') res++
        }
    }

    return res
}