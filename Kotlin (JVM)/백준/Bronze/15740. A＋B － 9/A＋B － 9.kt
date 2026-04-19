import  java.io.*
import java.math.BigInteger

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val num = br.readLine().split(" ")

    bw.write("${num[0].toBigInteger().add(BigInteger(num[1]))}")

    bw.close()
    br.close()
}