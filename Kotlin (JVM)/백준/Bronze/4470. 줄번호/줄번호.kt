import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    for (i in 1..br.readLine().toInt())
        bw.write("$i. ${br.readLine()}\n")

    bw.close()
    br.close()
}