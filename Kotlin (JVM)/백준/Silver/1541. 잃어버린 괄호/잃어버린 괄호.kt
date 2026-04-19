import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val cal = br.readLine().split('-').toTypedArray()

    var res = cal[0].split('+').sumOf { it.toInt() }

    for (i in 1 until cal.size) {
        res -= cal[i].split('+').sumOf { it.toInt() }
    }

    bw.write("$res")

    bw.close()
    br.close()
}