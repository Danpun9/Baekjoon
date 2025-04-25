import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val t = br.readLine().toInt()

    repeat(t) {
        val len = br.readLine().length

        bw.write(if (len in 6..9) "yes\n" else "no\n")
    }
    bw.close()
    br.close()
}
