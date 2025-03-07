import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine().toInt()

    var nn = n
    var cnt = 0

    do {
        nn = (nn % 10 + nn / 10) % 10 + (nn % 10) * 10
        cnt++
    } while (nn != n)

    bw.write("$cnt\n")

    bw.close()
    br.close()
}