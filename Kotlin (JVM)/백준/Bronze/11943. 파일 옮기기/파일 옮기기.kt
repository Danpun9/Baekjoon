import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.min

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val (a, b) = br.readLine().split(' ').map { it.toInt() }
    val (c, d) = br.readLine().split(' ').map { it.toInt() }

    val res = min(a + d, b + c)
    bw.write("$res")

    bw.close()
    br.close()
}