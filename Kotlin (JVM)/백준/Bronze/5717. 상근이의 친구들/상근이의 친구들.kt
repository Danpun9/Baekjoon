import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    while (true) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }

        if (a == 0 && b == 0) break

        bw.write("${a + b}\n")
    }

    bw.close()
    br.close()
}