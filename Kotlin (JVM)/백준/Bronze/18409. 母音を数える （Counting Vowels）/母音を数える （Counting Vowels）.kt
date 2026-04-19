import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    br.readLine()
    val str = br.readLine()

    var res = 0
    for (i in str) {
        if (i == 'a' || i == 'i' || i == 'u' || i == 'e' || i == 'o') res++
    }

    bw.write("$res\n")

    bw.close()
    br.close()
}
