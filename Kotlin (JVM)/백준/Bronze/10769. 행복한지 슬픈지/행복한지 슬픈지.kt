import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val str = br.readLine()

    var happy = 0
    var sad = 0

    for (i in 0 until str.length - 2) {
        val sub = str.substring(i, i + 3)

        when (sub) {
            ":-)" -> happy++
            ":-(" -> sad++
        }
    }

    if (happy > sad) bw.write("happy")
    else if (sad > happy) bw.write("sad")
    else if (happy != 0) bw.write("unsure")
    else bw.write("none")

    bw.close()
    br.close()
}