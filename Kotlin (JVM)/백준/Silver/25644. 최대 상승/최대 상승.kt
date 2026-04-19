import java.io.*
import kotlin.math.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine().toInt()

    val price = br.readLine().split(" ").map { it.toInt() }.toTypedArray()

    var min = Int.MAX_VALUE
    var res = 0
    for (i in price) {
        res = max(res, i - min)
        min = min(min, i)
    }

    bw.write("$res")

    bw.close()
    br.close()
}