import java.io.*
import kotlin.math.sqrt

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine().toDouble()

    bw.write("${(n * n) * sqrt(3.0) / 4}")

    bw.close()
    br.close()
}