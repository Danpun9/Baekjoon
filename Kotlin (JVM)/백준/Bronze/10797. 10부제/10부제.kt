import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine().toInt()
    val arr = br.readLine().split(" ").map { it.toInt() }.toIntArray()

    var res = 0
    arr.forEach { if (it == n) res++ }

    bw.write("$res\n")

    bw.close()
    br.close()
}