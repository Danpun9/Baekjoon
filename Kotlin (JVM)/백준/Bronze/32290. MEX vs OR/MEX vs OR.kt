import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val (l, r, x) = br.readLine().split(' ').map { it.toInt() }

    val arr = Array(1025) { false }

    for (i in l..r) {
        arr[i or x] = true
    }

    var res = 0

    for (i in 0 until arr.size) {
        if (!arr[i]) {
            res = i
            break
        }
    }

    bw.write("$res")

    bw.close()
    br.close()
}