import java.io.*

lateinit var mine: Array<CharArray>
var n = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    n = br.readLine().toInt()

    mine = Array(n) { br.readLine().toCharArray() }

    val opened = Array(n) { br.readLine().toCharArray() }

    val res = Array(n) { Array(n) { '.' } }

    val mineLocation = ArrayList<Pair<Int, Int>>()
    var isExplode = false

    for (i in 0 until n) {
        for (j in 0 until n) {
            if (mine[i][j] == '*') mineLocation.add(Pair(i, j))

            if (opened[i][j] != 'x') continue

            if (mine[i][j] == '*') {
                isExplode = true
                continue
            }

            res[i][j] = mineCheck(i, j)
        }
    }

    if (isExplode) {
        for ((y, x) in mineLocation) {
            res[y][x] = '*'
        }
    }

    for (i in res) {
        for (j in i) {
            bw.write("$j")
        }
        bw.write("\n")
    }

    bw.close()
    br.close()
}

fun mineCheck(y: Int, x: Int): Char {
    var res = 0

    val dx = arrayOf(1, -1, 0, 0, 1, 1, -1, -1)
    val dy = arrayOf(0, 0, 1, -1, 1, -1, 1, -1)

    for (i in 0..7) {
        val xx = x + dx[i]
        val yy = y + dy[i]

        if (xx < 0 || yy < 0 || xx >= n || yy >= n) continue

        if (mine[yy][xx] == '.') continue

        res++
    }
    
    return res.digitToChar()
}