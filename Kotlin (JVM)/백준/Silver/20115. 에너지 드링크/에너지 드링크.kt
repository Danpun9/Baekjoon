import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine().toInt()

    val arr = br.readLine().split(" ").map { it.toInt() }.toTypedArray()

    arr.sort()

    var res = arr[n - 1].toDouble()

    for (i in n - 2 downTo 0) res += arr[i].toDouble() / 2.0

    bw.write("$res")

    bw.close()
    br.close()
}