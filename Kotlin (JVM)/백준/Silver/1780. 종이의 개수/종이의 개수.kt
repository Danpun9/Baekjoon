import java.io.*

lateinit var arr: Array<Array<Int>>

var res1 = 0
var res0 = 0
var resn1 = 0

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()

    arr = Array(n) { br.readLine().split(' ').map { it.toInt() }.toTypedArray() }

    dfs(0, 0, n)

    bw.write("$resn1\n$res0\n$res1")

    bw.close()
    br.close()
}

fun isSquare(x: Int, y: Int, depth: Int): Boolean {
    val first = arr[y][x]

    for (i in y until y + depth)
        for (j in x until x + depth)
            if (arr[i][j] != first) return false

    return true
}

fun dfs(x: Int, y: Int, depth: Int) {
    if (isSquare(x, y, depth)) {
        when (arr[y][x]) {
            1 -> res1++
            0 -> res0++
            -1 -> resn1++
        }
        return
    }

    dfs(x, y, depth / 3)
    dfs(x + depth / 3, y, depth / 3)
    dfs(x + depth / 3 * 2, y, depth / 3)
    dfs(x, y + depth / 3, depth / 3)
    dfs(x + depth / 3, y + depth / 3, depth / 3)
    dfs(x + depth / 3 * 2, y + depth / 3, depth / 3)
    dfs(x, y + depth / 3 * 2, depth / 3)
    dfs(x + depth / 3, y + depth / 3 * 2, depth / 3)
    dfs(x + depth / 3 * 2, y + depth / 3 * 2, depth / 3)
}