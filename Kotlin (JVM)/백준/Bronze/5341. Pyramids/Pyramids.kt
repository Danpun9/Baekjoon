import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val br = BufferedReader(InputStreamReader(System.`in`))

    while (true) {
        val n = br.readLine().toInt()

        if (n == 0) break

        bw.write("${n * (n + 1) / 2}\n")
    }

    bw.close()
    br.close()
}