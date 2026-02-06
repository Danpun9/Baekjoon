import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val (n, k) = br.readLine()!!.split(" ").map { it.toLong() }

    bw.write("${n * n * k}")

    bw.close()
    br.close()
}