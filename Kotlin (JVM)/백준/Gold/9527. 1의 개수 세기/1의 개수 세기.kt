import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.ln


val dp = LongArray(55)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val (a, b) = br.readLine().split(" ").map { it.toLong() }


    initDP()

    val res = oneCnt(b) - oneCnt(a - 1)
    bw.write("$res\n")

    bw.close()
    br.close()
}

fun initDP() {
    dp[0] = 1

    for (i in 1..<55)
        dp[i] = (dp[i - 1] shl 1) + (1L shl i)
}

fun oneCnt(num: Long): Long {
    var x = num
    var cnt = x and 1L

    val size = (ln(x.toDouble()) / ln(2.0)).toInt()

    for (i in size downTo 1) {
        if ((x and (1L shl i)) != 0L) {
            cnt += dp[i - 1] + (x - (1L shl i) + 1)
            x -= (1L shl i)
        }
    }

    return cnt
}

