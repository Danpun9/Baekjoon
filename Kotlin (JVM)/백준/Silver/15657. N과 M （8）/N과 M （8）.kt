import java.io.*

val bw = BufferedWriter(OutputStreamWriter(System.`out`))

lateinit var arr: IntArray
lateinit var res: IntArray
var N = 0
var M = 0


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    N = n
    M = m

    arr = br.readLine().split(" ").map { it.toInt() }.toIntArray().sortedArray()
    res = IntArray(M)

    dfs(0, 0)
    bw.flush()

    bw.close()
    br.close()
}

fun dfs(idx: Int, depth: Int) {
    if (depth == M) {
        bw.write(res.joinToString(" "))
        bw.write("\n")
        return
    }

    for (i in idx..<N) {
        res[depth] = arr[i]
        dfs(i, depth + 1)
    }
}