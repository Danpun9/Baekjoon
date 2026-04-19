import java.io.*
import kotlin.math.max

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine().toInt()

    val map = HashMap<String, Int>()
    val q = ArrayDeque<Senior>()

    repeat(n) {
        val senior = br.readLine().split(" ")
        q.addFirst(Senior(senior[0], senior[1].toInt(), senior[2].toInt(), senior[3].toInt()))
    }

    repeat(n) {
        val senior = br.readLine().split(" ")
        map[senior[0]] = senior[1].toInt()
    }

    val days = Array(70) { false }

    while (q.isNotEmpty()) {
        val senior = q.removeLast()
        if (map[senior.name]!! >= senior.cost) days[(senior.w - 1) * 7 + senior.d] = true
    }

    var res = 0
    var day = 0
    var isAte = false

    for (i in days) {
        if (i) {
            if (isAte) day++
            else {
                isAte = true
                day = 1
            }
        } else isAte = false

        res = max(res, day)
    }

    bw.write("$res")

    bw.close()
    br.close()
}

data class Senior(val name: String, val w: Int, val d: Int, val cost: Int)
