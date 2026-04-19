import java.io.*
import kotlin.math.min

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val (n, s) = br.readLine().split(" ").map { it.toInt() }

    val arr = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    val num = IntArray(n + 1)
    for (i in 0 until n) num[i] = arr[i]

    var l = 0
    var r = 0
    var sum = num[0]
    var res = n + 1

    while (r in l..<n) {
        if (sum < s) sum += num[++r]
        else {
            res = min(res, r - l + 1)
            sum -= num[l++]
        }
    }

    bw.write(if (res == n + 1) "0" else "$res")

    bw.close()
    br.close()
}