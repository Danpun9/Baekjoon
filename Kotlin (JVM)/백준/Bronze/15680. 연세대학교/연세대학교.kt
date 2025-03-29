import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine().toInt()

    bw.write(
        when (n) {
            0 -> "YONSEI"
            else -> "Leading the Way to the Future"
        }
    )

    bw.close()
    br.close()
}
