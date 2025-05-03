import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine()

    bw.write(
        when (n) {
            "NLCS" -> "North London Collegiate School"
            "BHA" -> "Branksome Hall Asia"
            "KIS" -> "Korea International School"
            else -> "St. Johnsbury Academy"
        }
    )

    bw.close()
    br.close()
}
