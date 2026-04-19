import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val str = br.readLine()

    if (str[0] == 'N' || str[0] == 'n') bw.write("Naver D2")
    else bw.write("Naver Whale")

    bw.close()
    br.close()
}
