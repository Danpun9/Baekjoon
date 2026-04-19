import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.min

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine().toInt()
    val k = br.readLine().toInt()

    var l = 1L
    var r = k.toLong()

    while (l < r) {
        val mid = (r + l) / 2
        var cnt = 0L

        for (i in 1..n) {
            cnt += min(mid / i, n.toLong())
        }

        if (k <= cnt) r = mid
        else l = mid + 1
    }

    bw.write("$l")

    bw.close()
    br.close()
}