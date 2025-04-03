import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val div = 1_000_000_007L
    val a = br.readLine().toLong()
    val x = br.readLine().toLong()

    val cache = LongArray(64)
    cache[0] = a % div

    for (i in 1..<64) cache[i] = (cache[i - 1] * cache[i - 1]) % div

    var res = 1L

    for (i in 63 downTo 0)
        if (x and (1L shl i) != 0L)
            res = res * cache[i] % div


    bw.write("$res\n")

    bw.close()
    br.close()
}