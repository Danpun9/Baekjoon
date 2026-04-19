import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    val arr = Array(n + 1) { Array(n + 1) { 0 } }



    for (i in 1..n) {
        val st = StringTokenizer(br.readLine())
        for (j in 1..n) {
            arr[i][j] = arr[i - 1][j] + arr[i][j - 1] - arr[i - 1][j - 1] + st.nextToken().toInt()
        }
    }

    for (i in 1..m) {
        val (x1, y1, x2, y2) = br.readLine().split(" ").map { it.toInt() }

        bw.write("${arr[x2][y2] - arr[x1 - 1][y2] - arr[x2][y1 - 1] + arr[x1 - 1][y1 - 1]}\n")
    }

    bw.close()
    br.close()
}