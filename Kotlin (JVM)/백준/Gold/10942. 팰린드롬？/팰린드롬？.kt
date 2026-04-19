import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine().toInt()


    val arr = br.readLine().split(" ").map { it.toInt() }
    val isPalin = Array(n) { Array(n) { false } }

    for (i in 0 until n - 1) {
        isPalin[i][i] = true
        if (arr[i] == arr[i + 1]) {
            isPalin[i][i + 1] = true
        }
    }
    isPalin[n - 1][n - 1] = true

    for (i in n-2 downTo  0) {
        for (j in i + 2 until n) {
            if (arr[i] == arr[j] && isPalin[i + 1][j - 1]) {
                isPalin[i][j] = true
            }
        }
    }

    val m = br.readLine().toInt()
    for (i in 1..m) {
        val (s, e) = br.readLine().split(" ").map { it.toInt()-1 }
        bw.write("${if (isPalin[s][e]) 1 else 0}\n")
    }

    bw.close()
    br.close()
}