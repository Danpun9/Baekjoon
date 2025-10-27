import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine().toInt()

    val averages = mutableListOf<Long>()
    repeat(n) {
        val avg = br.readLine().replace(".", "").toLong()
        averages.add(avg)
    }

    var p = 1
    while (true) {
        var allValidForThisP = true
        val pLong = p.toLong()

        for (g_i in averages) {
            val l = g_i * pLong
            val r = (g_i + 1) * pLong - 1

            val smallestMultiple = ((l + 999) / 1000) * 1000

            if (smallestMultiple > r) {
                allValidForThisP = false
                break
            }
        }

        if (allValidForThisP) {
            println(p)
            break
        }

        p++
    }

    bw.close()
    br.close()
}