import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.math.BigInteger

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine()

    var remainder = 0L

    for (i in 0 until n.length) {
        remainder = (remainder * 10 + (n[i] - '0')) % 20000303
    }

    bw.write("$remainder")

    bw.close()
    br.close()
}
