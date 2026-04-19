import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine().toInt()

    val isOdd = if (n % 2 == 0) false else true
    bw.write("YES\n")

    for (i in n - 1 downTo 1 step 2)
        bw.write("$i ")

    bw.write("$n")

    if (isOdd) {
        for (i in 1..n - 2 step 2)
            bw.write(" $i")
    } else {
        for (i in 2..n - 2 step 2)
            bw.write(" $i")
    }

    bw.write("\n")

    for (i in 1..n / 2) {
        bw.write("$i ${n - i + 1} ")
    }
    if (isOdd) bw.write("${n / 2 + 1}")

    bw.close()
    br.close()
}