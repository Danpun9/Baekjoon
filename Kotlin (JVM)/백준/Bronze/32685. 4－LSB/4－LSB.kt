import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.text.DecimalFormat

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val num = Array(3) { Integer.toBinaryString(br.readLine().toInt()) }

    for (i in 0..2)
        if (num[i].length < 4)
            while (num[i].length != 4)
                num[i] = "0" + num[i]

    var resBinary = ""

    for (i in 0..2) {
        resBinary += num[i].substring(num[i].length - 4, num[i].length)
    }

    val res = resBinary.toInt(2)
    val dec = DecimalFormat("0000")

    bw.write(dec.format(res))


    bw.close()
    br.close()
}