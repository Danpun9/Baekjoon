import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val str = br.readLine()

    var res = 0
    str.forEach { if (it == 'a' || it == 'e' || it == 'i' || it == 'o' || it == 'u') res++ }

    bw.write("$res\n")

    bw.close()
    br.close()
}