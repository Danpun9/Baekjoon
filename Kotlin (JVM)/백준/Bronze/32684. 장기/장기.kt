import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val cocjr0208 = br.readLine().split(' ').map { it.toDouble() }
    val ekwoo = br.readLine().split(' ').map { it.toDouble() }

    val score = arrayOf(13.0, 7.0, 5.0, 3.0, 3.0, 2.0)

    var res1 = 0.0
    var res2 = 0.0

    for (i in 0..5) {
        res1 += cocjr0208[i] * score[i]
        res2 += ekwoo[i] * score[i]
    }
    res2 += 1.5

    if (res1 > res2) bw.write("cocjr0208")
    else bw.write("ekwoo")

    bw.close()
    br.close()
}