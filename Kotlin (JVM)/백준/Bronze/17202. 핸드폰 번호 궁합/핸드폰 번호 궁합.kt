import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val num1 = br.readLine()
    val num2 = br.readLine()

    var str = ""
    for (i in 0 until 8) {
        str += num1[i]
        str += num2[i]
    }

    while (true) {
        if (str.length == 2) break

        var nextStr = ""

        for (i in 1 until str.length) {
            nextStr += ((str[i - 1] - '0') + (str[i] - '0')) % 10
        }

        str = nextStr
    }

    bw.write(str)

    bw.close()
    br.close()
}