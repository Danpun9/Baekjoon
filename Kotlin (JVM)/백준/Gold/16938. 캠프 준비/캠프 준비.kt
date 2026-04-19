import java.io.*
import kotlin.math.max
import kotlin.math.min

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (n, l, r, x) = br.readLine().split(' ').map { it.toInt() }.toTypedArray()

    val problem = br.readLine().split(' ').map { it.toInt() }.toTypedArray()
    problem.sort()

    var res = 0

    for (i in 1 until (1 shl n)) {
        var cnt = 0
        var total = 0
        var max = Int.MIN_VALUE
        var min = Int.MAX_VALUE

        for (j in 0 until n) {
            if (i and (1 shl j) > 0) {
                cnt++
                total += problem[j]
                max = max(max, problem[j])
                min = min(min, problem[j])
            }
        }

        if (cnt >= 2 && total >= l && total <= r && max - min >= x) res++
    }

    bw.write(res.toString())

    bw.close()
    br.close()
}