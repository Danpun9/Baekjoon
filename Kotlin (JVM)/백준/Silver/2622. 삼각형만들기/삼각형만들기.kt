import java.io.*

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()

    var res = 0
    for (i in 1 until n) {
        for (j in i until n) {
            val k = n - i - j
            if (k < j) break
            if (k < i + j) res++
        }
    }

    bw.write("$res")

    bw.close()
    br.close()
}

