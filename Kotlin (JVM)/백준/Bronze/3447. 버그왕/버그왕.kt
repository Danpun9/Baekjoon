import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    while (true) {
        var str = br.readLine() ?: break

        var i = 0
        while (i < str.length - 2) {
            if (str.substring(i, i + 3).equals("BUG")) {
                str = str.substring(0, i) + str.substring(i + 3, str.length)
                i = 0
            } else {
                i++
            }
        }

        bw.write("${str}\n")
    }


    bw.close()
    br.close()
}