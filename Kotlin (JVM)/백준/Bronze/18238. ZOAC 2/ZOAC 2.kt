import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val str = 'A' + br.readLine()

    var res = 0
    var curr = 'A'

    for (i in 1 until str.length) {
        val a: Int = str[i] - 'A'
        val b: Int = str[i - 1] - 'A'

        val time = Math.abs(a - b)
        res += Math.min(time, 26 - time)
    }

    bw.write("$res")

    bw.close()
    br.close()
}