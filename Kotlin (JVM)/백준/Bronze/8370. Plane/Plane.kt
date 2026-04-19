import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val (n1, k1, n2, k2) = br.readLine().split(" ").map { it.toInt() }

    bw.write("${n1 * k1 + n2 * k2}\n")

    bw.close()
    br.close()
}