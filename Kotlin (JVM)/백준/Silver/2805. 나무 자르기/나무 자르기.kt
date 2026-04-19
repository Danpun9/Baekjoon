import java.io.*

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (n, m) = br.readLine().split(' ').map { it.toInt() }

    val arr = br.readLine().split(' ').map { it.toInt() }.toTypedArray()

    arr.sort()

    var left = 0
    var right = arr[n - 1]
    var res = 0

    while (left <= right) {
        val mid = (right + left) / 2

        val sum = arr.sumOf { if (it - mid > 0) (it - mid).toLong() else 0L }

        if (sum >= m) {
            res = mid
            left = mid + 1
        } else right = mid - 1
    }

    bw.write("$res")

    bw.close()
    br.close()
}