import java.io.*

val bw = BufferedWriter(OutputStreamWriter(System.`out`))
lateinit var arr: Array<Array<Boolean>>

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))


    val n = br.readLine().toInt()

    arr = Array(n) { br.readLine().map { it - '0' == 1 }.toTypedArray() }

    dfs(0, 0, n)

    bw.flush()

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
        bw.write(if (arr[y][x]) "1" else "0")
        return
    }

    bw.write("(")
    dfs(x, y, depth / 2)
    dfs(x + depth / 2, y, depth / 2)
    dfs(x, y + depth / 2, depth / 2)
    dfs(x + depth / 2, y + depth / 2, depth / 2)
    bw.write(")")

}