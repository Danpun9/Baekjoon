import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val t = br.readLine().toInt()

    repeat(t) {
        val (n, m) = br.readLine().split(' ').map { it.toInt() }
        repeat(m) {
            br.readLine()
        }
        bw.write("${n - 1}\n")
    }

    bw.close()
    br.close()
}
