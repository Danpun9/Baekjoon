import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val br = BufferedReader(InputStreamReader(System.`in`))

    val P1 = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    val P2 = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    val P3 = br.readLine().split(" ").map { it.toInt() }.toIntArray()

    val a = P1[0] * P2[1] + P2[0] * P3[1] + P3[0] * P1[1]
    val b = P3[0] * P2[1] + P2[0] * P1[1] + P1[0] * P3[1]

    if (a - b == 0) bw.write("0\n")
    else if (a - b > 0) bw.write("1\n")
    else bw.write("-1\n")

    bw.close()
    br.close()
}