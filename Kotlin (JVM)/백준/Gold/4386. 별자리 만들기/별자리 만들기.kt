import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.PriorityQueue
import kotlin.math.abs
import kotlin.math.pow
import kotlin.math.sqrt

lateinit var parent: IntArray

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()

    parent = IntArray(n) { it }
    val pq = PriorityQueue<Edge>()

    val edgeList = Array(n) { br.readLine().split(" ").map { it.toDouble() }.toDoubleArray() }
    for (i in 0..<n - 1) {
        for (j in i + 1..<n) {
            val w = sqrt(abs(edgeList[i][0] - edgeList[j][0]).pow(2) + abs(edgeList[i][1] - edgeList[j][1]).pow(2))

            pq.add(Edge(i, j, w))
        }
    }

    var res = 0.0

    while (pq.isNotEmpty()) {
        val edge = pq.remove()

        val ap = findParent(edge.a)
        val bp = findParent(edge.b)

        if (ap == bp) continue

        res += edge.w

        if (ap > bp) parent[bp] = ap
        else parent[ap] = bp
    }

    bw.write("$res")


    bw.close()
    br.close()
}

class Edge(val a: Int, val b: Int, val w: Double) : Comparable<Edge> {
    override fun compareTo(other: Edge): Int {
        return compareValues(this.w, other.w)
    }
}

fun findParent(x: Int): Int {
    if (parent[x] == x) return parent[x]

    parent[x] = findParent(parent[x])
    return parent[x]
}