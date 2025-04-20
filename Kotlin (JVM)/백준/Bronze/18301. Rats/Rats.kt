import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val (n1, n2, n3) = br.readLine().split(" ").map { it.toInt() + 1 }

    bw.write("${n1 * n2 / n3 - 1}")

    bw.close()
    br.close()
}
