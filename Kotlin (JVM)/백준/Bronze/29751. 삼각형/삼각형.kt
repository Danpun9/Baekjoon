import java.io.*
import java.text.DecimalFormat

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (w, h) = br.readLine().split(' ').map { it.toDouble() }

    val res = w * h / 2.0
    val format = DecimalFormat("0.0")

    bw.write(format.format(res))

    bw.close()
    br.close()
}