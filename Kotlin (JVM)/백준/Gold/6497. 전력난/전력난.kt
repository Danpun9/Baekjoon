import java.io.*
import java.util.PriorityQueue

lateinit var parent: IntArray

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    while (true) {
        val (v, e) = br.readLine().split(" ").map { it.toInt() }

        if (v == 0 && e == 0) break

        parent = IntArray(v + 1) { it }
        val pq = PriorityQueue<Edge>()
        var sum = 0

        repeat(e) {
            val (a, b, c) = br.readLine().split(" ").map { it.toInt() }
            pq.add(Edge(a, b, c))
            sum += c
        }

        var res = 0

        while (pq.isNotEmpty()) {
            val edge = pq.remove()

            val ap = findParent(edge.a)
            val bp = findParent(edge.b)

            if (ap == bp) continue

            if (ap > bp) parent[ap] = bp
            else parent[bp] = ap

            res += edge.w
        }

        bw.write("${sum - res}\n")
    }
    bw.close()
    br.close()
}

class Edge(val a: Int, val b: Int, val w: Int) : Comparable<Edge> {
    override fun compareTo(other: Edge): Int {
        return w - other.w
    }
}

fun findParent(x: Int): Int {
    if (x == parent[x]) return x

    parent[x] = findParent(parent[x])

    return parent[x]
}