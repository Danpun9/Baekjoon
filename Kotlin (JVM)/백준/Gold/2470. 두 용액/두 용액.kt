import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.abs

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine().toInt()

    val arr = br.readLine().split(' ').map { it.toInt() }.sorted().toTypedArray()

    var left = 0
    var right = n - 1

    var min = Int.MAX_VALUE
    var res1 = 0
    var res2 = 0

    while (left < right) {
        val sum = arr[right] + arr[left]

        if (abs(sum) < min) {
            res1 = arr[left]
            res2 = arr[right]
            min = abs(sum)

            if (min == 0) break
        }

        if (sum > 0) right--
        else left++
    }

    bw.write("$res1 $res2")

    bw.close()
    br.close()
}