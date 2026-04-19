import java.io.*
import java.math.BigInteger

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toBigInteger()

    val res = n.add(n.subtract(BigInteger.valueOf(2)))

    if (n == BigInteger.valueOf(1)) bw.write("1")
    else bw.write("$res")

    bw.close()
    br.close()
}