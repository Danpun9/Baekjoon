import java.io.*
import kotlin.math.abs

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine().toInt()

    val arr = Array(n) { br.readLine().toInt() - 1 }

    arr.sort()

    var res = 0L
    for (i in 0 until n) {
        res += abs(i - arr[i])
    }

    bw.write("$res")

    bw.close()
    br.close()
}