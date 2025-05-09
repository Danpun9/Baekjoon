import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val (n, a, b) = br.readLine().split(" ").map { it.toInt() }

    var res = -1

    bw.write(if (a == b) "Anything\n" else if (a < b) "Bus\n" else "Subway\n")

    bw.close()
    br.close()
}
