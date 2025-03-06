import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val (n, c) = br.readLine().split(' ').map { it.toInt() }

    val arr = Array(n) { br.readLine().toInt() }
    arr.sort()
    
    var l = 1
    var r = arr[n - 1] - arr[0] + 1

    while (l < r) {
        val dist = (r + l) / 2

        var cnt = 1
        var prev = arr[0]

        for (i in 1 until n) {
            if (arr[i] - prev >= dist) {
                cnt++
                prev = arr[i]
            }
        }

        if (cnt < c) r = dist
        else l = dist + 1
    }
    
    bw.write("${l - 1}")

    bw.close()
    br.close()
}