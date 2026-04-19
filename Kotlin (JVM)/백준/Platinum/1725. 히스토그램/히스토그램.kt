import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.max

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine().toInt()
    val histogram = LongArray(n) { br.readLine().toLong() }

    val s = ArrayDeque<Int>()

    var res = 0L

    for (i in 0 until n) {

        while (s.isNotEmpty() && histogram[s.first()] >= histogram[i]) {
            val h = histogram[s.removeFirst()]

            val w = if (s.isNotEmpty()) (i - 1 - s.first()).toLong() else i.toLong()

            res = max(res, h * w)
        }

        s.addFirst(i)
    }

    while (s.isNotEmpty()) {
        val h = histogram[s.removeFirst()]

        val w = if (s.isNotEmpty()) (n - 1 - s.first()).toLong() else n.toLong()

        res = max(res, h * w)
    }

    bw.write("$res")

    bw.close()
    br.close()
}
