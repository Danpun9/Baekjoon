import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine().toLong()

    val num = br.readLine().split(" ").map { it.toLong() }.toTypedArray()

    var res = n * (n + 1) / 2

    for (i in num) res -= i

    bw.write("$res")

    bw.close()
    br.close()
}