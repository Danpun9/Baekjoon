import java.io.*

lateinit var res: Array<BooleanArray>
var N = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    N = br.readLine().toInt()

    res = Array(N) { BooleanArray(N * 2) }

    recursion(0, N - 1, N)

    res.forEach {
        it.forEach { star -> bw.write(if (star) "*" else " ") }
        bw.write("\n")
    }

    bw.close()
    br.close()
}

fun recursion(y: Int, x: Int, n: Int) {
    if (n == 3) {
        res[y][x] = true
        res[y + 1][x - 1] = true
        res[y + 1][x + 1] = true
        res[y + 2][x - 2] = true
        res[y + 2][x - 1] = true
        res[y + 2][x - 0] = true
        res[y + 2][x + 1] = true
        res[y + 2][x + 2] = true
        return
    }

    recursion(y, x, n / 2)
    recursion(y + n / 2, x - (n / 3) - (n / 3) / 2, n / 2)
    recursion(y + n / 2, x + (n / 3) + (n / 3) / 2, n / 2)

}