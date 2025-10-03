import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    var res = br.readLine().toInt()

    repeat(9) {
        res -= br.readLine().toInt()
    }

    bw.write("$res\n")

    bw.close()
    br.close()
}