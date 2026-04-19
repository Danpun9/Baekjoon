import java.io.*
import java.math.BigInteger

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val a = br.readLine().toBigInteger()
    val b = br.readLine().toBigInteger()

    bw.write("${(a + b).divide(BigInteger.valueOf(2))}\n")
    bw.write("${(a - b).divide(BigInteger.valueOf(2))}\n")

    bw.close()
    br.close()
}
