import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val br = BufferedReader(InputStreamReader(System.`in`))

    while (true) {
        val str = br.readLine() ?: break

        val (n, s) = str.split(" ").map { it.toInt() }

        bw.write("${s / (n + 1)}\n")
    }


    bw.close()
    br.close()
}