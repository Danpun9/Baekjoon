import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val t = br.readLine().toInt()
    repeat(t) {
        val (m, n, x, y) = br.readLine().split(" ").map { it.toInt() }

        var res = x
        var flag = false
        while (res <= m * n) {
            if ((res - x) % m == 0 && (res - y) % n == 0) {
                flag = true
                break
            }
            res += m
        }

        bw.write((if (flag) "$res" else "-1") + "\n")
    }

    bw.close()
    br.close()
}
