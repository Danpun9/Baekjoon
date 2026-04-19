import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()

    val arr = Array(n) { br.readLine().split(" ").map { it.toInt() } }
    val check = Array(n) { BooleanArray(n) }

    for (grade in 0..<5) {
        for (i in 0..<n - 1) {
            for (j in i + 1..<n) {
                if (arr[i][grade] == arr[j][grade]) {
                    check[i][j] = true
                    check[j][i] = true
                }
            }
        }
    }

    var res = Int.MIN_VALUE
    var max = Int.MIN_VALUE

    for (i in 0..<n) {
        var cnt = 0

        check[i].forEach { if (it) cnt++ }

        if (cnt > max) {
            max = cnt
            res = i + 1
        }
    }

    bw.write("$res")

    bw.close()
    br.close()
}

