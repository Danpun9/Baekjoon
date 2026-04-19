import java.io.*
import java.util.*

lateinit var paper: Array<List<Boolean>>
val cnt = IntArray(2)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine().toInt()

    paper = Array(n) { br.readLine().split(" ").map { if (it.toInt() == 1) true else false } }

    dfs(0, 0, n)

    bw.write("${cnt[0]}\n${cnt[1]}\n")

    bw.close()
    br.close()
}

fun dfs(x: Int, y: Int, depth: Int) {
    if (isSquare(x, y, depth)) {
        if (paper[x][y]) cnt[1]++
        else cnt[0]++
        return
    }

    dfs(x, y, depth / 2)
    dfs(x, y + depth / 2, depth / 2)
    dfs(x + depth / 2, y, depth / 2)
    dfs(x + depth / 2, y + depth / 2, depth / 2)
}

fun isSquare(x: Int, y: Int, depth: Int): Boolean {
    val color = paper[x][y]

    for (i in x until x + depth) {
        for (j in y until y + depth) {
            if (color != paper[i][j]) return false
        }
    }

    return true
}
