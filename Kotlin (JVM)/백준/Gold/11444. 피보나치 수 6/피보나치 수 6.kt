import java.io.*
import kotlin.collections.*

val div = 1_000_000_007

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toLong()

    bw.write(fibo(n).toString())

    bw.close()
    br.close()
}

val map = mutableMapOf<Long, Long>()
fun fibo(n: Long): Long {
    if (n == 0L) return 0
    if (n == 1L) return 1
    if (n == 2L) return 1
    if (map[n] != null) return map[n]!!

    if (n % 2 == 0L) {
        val m = n / 2
        val temp1 = fibo(m - 1)
        val temp2 = fibo(m)

        map[n] = ((2 * temp1 + temp2)) * temp2 % div
        return map[n]!!
    } else {
        val m = (n + 1) / 2
        val temp1 = fibo(m)
        val temp2 = fibo(m - 1)

        map[n] = (temp1 * temp1 + temp2 * temp2) % div
        return map[n]!!
    }
}