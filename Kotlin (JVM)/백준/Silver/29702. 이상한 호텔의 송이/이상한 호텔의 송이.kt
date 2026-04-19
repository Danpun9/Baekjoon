import java.io.*
import java.text.DecimalFormat

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val t = br.readLine().toInt()

    repeat(t) {
        val curr = br.readLine().toLong()

        var level = 1
        var num = 1L

        while (curr >= num * 2) {
            level++
            num *= 2
        }

        num = curr - num + 1
        val format = DecimalFormat("000000000000000000")

        for (i in 1..level) {
            val room = format.format(num)
            bw.write("$level$room\n")
            level--
            num = if (num % 2 == 0L) num / 2 else num / 2 + 1
        }
    }
    
    bw.close()
    br.close()
}