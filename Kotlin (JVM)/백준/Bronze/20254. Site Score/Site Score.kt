import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.PriorityQueue

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val (a, b, c, d) = br.readLine().split(" ").map { it.toInt() }

    bw.write("${a * 56 + b * 24 + c * 14 + d * 6}\n")

    bw.close()
    br.close()
}
