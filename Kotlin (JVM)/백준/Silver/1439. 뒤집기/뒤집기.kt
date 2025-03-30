import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val str = br.readLine()

    var cnt = 0

    for (i in 1..<str.length) {
        if (str[i] != str[i - 1])
            cnt++
    }

    bw.write("${(cnt + 1) / 2}")
    
    bw.close()
    br.close()
}