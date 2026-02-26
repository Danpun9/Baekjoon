import java.io.*
import kotlin.system.exitProcess

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    val arr = Array(n) { br.readLine().split(" ").map { it.toInt() }.toIntArray() }

    arr.sortWith { o1, o2 -> o1.sum() - o2.sum() }

    for (i in 0..<n - 1) {
        for (j in 0..<m) {
            if (arr[i][j] > arr[i + 1][j]) {
                bw.write("NO\n")
                bw.flush()

                exitProcess(0)
            }

        }
    }

    bw.write("YES\n")

    bw.close()
    br.close()
}