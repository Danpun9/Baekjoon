import java.io.*

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()

    val arr = br.readLine().split(' ').map { it.toInt() }.sorted().toTypedArray()

    val x = br.readLine().toInt()

    var startIdx = 0
    var endIdx = n - 1

    var res = 0

    while (startIdx < endIdx) {
        val curr = arr[endIdx] + arr[startIdx]

        if (curr == x) res++
        if (curr < x) startIdx++
        else endIdx--
    }

    bw.write("$res")

    bw.close()
    br.close()
}
