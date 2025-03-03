import java.io.*
import kotlin.math.pow
import kotlin.math.sqrt

lateinit var parent: IntArray

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val (x, y, d, t) = br.readLine().split(" ").map { it.toDouble() }

    val dist = sqrt(x.pow(2) + y.pow(2))
    var res = dist

    if (t > d) bw.write("$res\n")
    else {
        val n = (dist / d).toInt() // 점프 횟수

        res = minOf(res, (dist - d * n) + t * n) // 점프 후 남은 거리 걷기 (x>=0, y>=0)
        res = minOf(res, (d * (n + 1) - dist) + t * (n + 1)) // 점프 한 번 더(0,0 지나침)후 0,0까지 걷기

        // 우회해서 점프 후 도착 (직선 이동x)
        if (n > 0) {
            res = minOf(res, (n + 1) * t)
        } else if (dist < d)
            res = minOf(res, t * 2)
    }

    bw.write("$res")


    bw.close()
    br.close()
}