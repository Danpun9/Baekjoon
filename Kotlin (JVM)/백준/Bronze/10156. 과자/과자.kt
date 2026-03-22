import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val (k, n, m) = br.readLine().split(" ").map { it.toInt() }

    val res = m - (n * k)
    if (res >= 0) bw.write("0\n")
    else bw.write("${-res}\n")

    bw.close()
    br.close()
}