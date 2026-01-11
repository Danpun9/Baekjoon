import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

lateinit var arr: Array<BooleanArray>
var N = 0


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    N = br.readLine().toInt()
    arr = Array(N * 4 - 3) { BooleanArray(N * 4 - 3) }

    recursion(0, N * 4 - 3)

    for (i in 0..<N * 4 - 3) {
        for (j in 0..<N * 4 - 3) {
            bw.write("${if (arr[i][j]) "*" else " "}")
        }
        bw.write("\n")
    }

    bw.close()
    br.close()
}

fun recursion(xy: Int, n: Int) {
    for (i in xy..<xy + n) {
        if (i == xy || i == xy + n - 1) {
            for (j in xy..<xy + n) {
                arr[i][j] = true
            }
        }

        arr[i][xy] = true
        arr[i][xy + n - 1] = true
    }

    if (n != 1) recursion(xy + 2, n - 4)

}