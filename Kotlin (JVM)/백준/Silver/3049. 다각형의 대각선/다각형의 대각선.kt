import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine().toInt()

    bw.write("${n * (n - 1) * (n - 2) * (n - 3) / (4 * 3 * 2 * 1)}\n") // nC4

    bw.close()
    br.close()
}
