import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val a = br.readLine().toInt()
    val b = br.readLine().toInt()

    bw.write("${b + (b - a)}\n")

    bw.close()
    br.close()
}