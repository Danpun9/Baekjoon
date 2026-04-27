import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = br.readLine().toInt()

    val res = Array(2 * n) { BooleanArray(4 * n + 2) }

    // /
    for (i in 0..<n * 2) {
        res[2 * n - 1 - i][i] = true
    }

    // < >
    for (i in n - 1 downTo 0) {
        // \
        res[i + n][i + (2 * n + 1)] = true
        res[i][i + (3 * n + 2)] = true
        // /
        res[n - i - 1][i + (2 * n + 1)] = true
        res[2 * n - i - 1][i + (3 * n + 2)] = true
    }

    // 출력
    for (i in 0..<2 * n) {
        for (j in 0..<4 * n + 2) {
            bw.write(if (res[i][j]) "*" else " ")
        }
        bw.write("\n")
    }

    bw.close()
    br.close()
}