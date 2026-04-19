import  java.io.*
import java.util.StringTokenizer

lateinit var arr: Array<Int>
var res = 0
var ss = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val (n, s) = br.readLine().split(" ").map { it.toInt() }
    ss = s

    arr = br.readLine().split(" ").map { it.toInt() }.toTypedArray()

    dfs(0, 0)

    if (ss == 0) res--

    bw.write("$res")

    bw.close()
    br.close()
}

fun dfs(idx: Int, sum: Int) {
    if (idx == arr.size) {
        if (sum == ss) res++
        return
    }

    dfs(idx + 1, sum + arr[idx])
    dfs(idx + 1, sum)
}