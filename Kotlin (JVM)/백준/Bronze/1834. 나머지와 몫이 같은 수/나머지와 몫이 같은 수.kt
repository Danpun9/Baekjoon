import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine().toLong()

    var sum = 0L

    for (i in 1 until n) {
        sum += n * i + i
    }

    bw.write("$sum")

    bw.close()
    br.close()
}