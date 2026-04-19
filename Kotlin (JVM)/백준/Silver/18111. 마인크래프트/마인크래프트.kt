import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.max

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val (n, m, b) = br.readLine().split(' ').map { it.toInt() }

    val ground = IntArray(n * m)

    for (i in 0 until n) {
        val tmp = br.readLine().split(' ').map { it.toInt() }

        for (j in 0 until m) {
            ground[i * m + j] = tmp[j]
        }
    }

    var res_time = Int.MAX_VALUE
    var res_top = -1

    for (target_top in ground.min()..ground.max()) {
        var install = 0
        var delete = 0

        for (i in 0 until n * m) {
            if (ground[i] > target_top) delete += ground[i] - target_top
            else install += target_top - ground[i]
        }

        if (install > delete + b) continue

        val time = delete * 2 + install

        if (res_time >= time) {
            res_time = time
            res_top = max(res_top, target_top)
        }
    }

    bw.write("$res_time $res_top")

    bw.close()
    br.close()
}