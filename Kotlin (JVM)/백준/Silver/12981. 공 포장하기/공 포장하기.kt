import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    var (r, g, b) = br.readLine().split(" ").map { it.toInt() }

    var res = minOf(minOf(r, g), b)

    r -= res
    g -= res
    b -= res

    res += r / 3 + g / 3 + b / 3
    r %= 3
    g %= 3
    b %= 3

    if (r == 2) {
        res++
        r = 0
    }
    if (g == 2) {
        res++
        g = 0
    }
    if (b == 2) {
        res++
        b = 0
    }
    if (r + g + b > 0) res++

    bw.write("$res\n")

    bw.close()
    br.close()
}
