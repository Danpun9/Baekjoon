import java.io.*
import kotlin.math.min

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine().toInt()

    val distanse = br.readLine().split(' ').map { it.toLong() }.toTypedArray()
    val cost = br.readLine().split(' ').map { it.toLong() }.toTypedArray()

    var res = cost[0] * distanse[0]
    var min = cost[0]

    for (i in 1 until n - 1) {
        min = min(min, cost[i])
        res += min * distanse[i]
    }

    bw.write("$res")

    bw.close()
    br.close()
}