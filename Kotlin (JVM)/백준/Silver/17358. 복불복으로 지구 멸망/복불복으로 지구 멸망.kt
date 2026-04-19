import java.io.*

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()

    val div = 1_000_000_007

    var res = 1L
    for (i in n downTo 1 step 2) {
        res *= (i - 1)
        res %= div
    }

    bw.write("$res")

    bw.close()
    br.close()
}