import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    repeat(br.readLine().toInt()) {
        br.readLine()
        bw.write("${br.readLine().split(" ").map { it.toInt() }.sum()}\n")
    }

    bw.close()
    br.close()
}