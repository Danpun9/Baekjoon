import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.PriorityQueue

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()

    val arr = Array(n) {
        val (start, end) = br.readLine().split(" ").map { it.toInt() }
        if (start > end) Edge(end, start)
        else Edge(start, end)
    }

    arr.sort()
    val d = br.readLine().toInt()

    var res = 0

    val pq = PriorityQueue<Int>()
    for (i in 0..<n) {
        if (arr[i].getLength() > d) continue

        pq.add(arr[i].start)

        while (pq.isNotEmpty()) {
            if (arr[i].end - pq.first() > d) pq.remove()
            else break
        }

        res = maxOf(res, pq.size)
    }

    bw.write("$res")

    bw.close()
    br.close()
}

data class Edge(var start: Int, var end: Int) : Comparable<Edge> {
    override fun compareTo(other: Edge): Int {
        return if (this.end == other.end) this.start - other.start
        else this.end - other.end
    }

    fun getLength(): Int {
        return this.end - this.start
    }
}