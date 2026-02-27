import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine().toInt()

    val arr = br.readLine().split(" ").map { it.toInt() }.toIntArray()

    val dp = IntArray(n) { 1 }

    for (i in 1..<n)
        if (arr[i] > arr[i - 1] || arr[i] >= dp[i - 1] + 1)
            dp[i] = dp[i - 1] + 1
        else if (arr[i] <= dp[i - 1]) {
            dp[i] = arr[i]
        }

    bw.write("${dp.max()}\n")
    
    bw.close()
    br.close()
}