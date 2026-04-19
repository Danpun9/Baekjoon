import java.io.*

lateinit var arr: IntArray
lateinit var dp: Array<Int?>
var n = 0
var res = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    n = br.readLine().toInt()
    arr = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    dp = Array(n) { null }


    dp[0] = arr[0]
    res = arr[0]
    
    dfs(n - 1)

    bw.write("$res")

    bw.close()
    br.close()
}

fun dfs(idx: Int): Int {
    if (dp[idx] == null) {
        dp[idx] = Math.max(dfs(idx - 1) + arr[idx], arr[idx])

        res = Math.max(res, dp[idx]!!)
    }

    return dp[idx]!!
}