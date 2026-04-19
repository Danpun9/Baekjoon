import java.io.*
import java.util.PriorityQueue

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine().toInt()

    val pq = PriorityQueue<Meeting>()

    repeat(n) {
        val seTime = br.readLine().split(' ').map { it.toInt() }
        pq.add(Meeting(seTime[0], seTime[1]))
    }

    var res = 1
    var lastTime = pq.remove().end

    while (pq.isNotEmpty()) {
        val cur = pq.remove()
        if (cur.start >= lastTime) {
            res++
            lastTime = cur.end
        }
    }

    bw.write("$res")

    bw.close()
    br.close()
}

class Meeting(val start: Int, val end: Int) : Comparable<Meeting> {
    override fun compareTo(other: Meeting): Int {
        return if (this.end == other.end) this.start - other.start
        else this.end - other.end
    }
}