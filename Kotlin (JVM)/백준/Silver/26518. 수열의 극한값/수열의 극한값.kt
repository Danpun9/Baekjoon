import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val (b, c, a1, a2) = br.readLine().split(" ").map { it.toDouble() }

    var res: Double = (b + Math.sqrt(Math.pow(b, 2.0) + 4 * c)) / 2

    bw.write("$res")

    bw.close()
    br.close()
}