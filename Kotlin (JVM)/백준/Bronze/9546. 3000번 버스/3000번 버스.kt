import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val t = br.readLine().toInt()

    val memo = Array(31) { 1 }

    for (i in 2..30) {
        memo[i] = memo[i - 1] * 2 + 1
    }

    for (i in 1..t) {
        val k = br.readLine().toInt()
        bw.write("${memo[k]}\n")
    }

    bw.close()
    br.close()
}