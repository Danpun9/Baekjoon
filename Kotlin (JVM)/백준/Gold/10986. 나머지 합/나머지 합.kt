import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val (n, m) = br.readLine().split(' ').map { it.toInt() }

    val arr = br.readLine().split(' ').map { it.toLong() }
    val sumArr = Array(n + 1) { 0L }
    val mArr = Array(m) { 0L }
    var res = 0L

    for (i in 1..n) {
        sumArr[i] = (arr[i - 1] + sumArr[i - 1]) % m
        if (sumArr[i] == 0L) res++
        mArr[sumArr[i].toInt()]++
    }

    for (i in 0 until m) {
        if (mArr[i] >= 2) res += (mArr[i] * (mArr[i] - 1) / 2)
    }

    bw.write("$res")

    bw.close()
    br.close()
}