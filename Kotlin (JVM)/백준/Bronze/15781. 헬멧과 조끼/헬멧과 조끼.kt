import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    br.readLine()
    val maxHelmet = br.readLine().split(" ").map { it.toInt() }.max()
    val maxVest = br.readLine().split(" ").map { it.toInt() }.max()

    bw.write("${maxHelmet + maxVest}\n")

    bw.close()
    br.close()
}