import java.io.*
import java.lang.Math.pow

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val (a, b, c) = br.readLine().split(' ').map { it.toDouble() }

    var res = 0.0

    when (0.0) {
        a -> res = pow(c, 2.0) - b
        b -> res = pow(c, 2.0) - a
        c -> res = (Math.sqrt(a + b))
    }

    bw.write("${res.toInt()}")

    bw.close()
    br.close()
}