import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val m = br.readLine().toInt()
    val d = br.readLine().toInt()

    if (m < 2 || m == 2 && d < 18)
        bw.write("Before")
    else if (m > 2 || d > 18)
        bw.write("After")
    else
        bw.write("Special")

    bw.close()
    br.close()
}