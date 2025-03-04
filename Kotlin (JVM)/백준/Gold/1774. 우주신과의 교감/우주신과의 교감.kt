import java.io.*
import java.util.PriorityQueue
import kotlin.math.pow
import kotlin.math.round

lateinit var parent: IntArray

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    parent = IntArray(n + 1) { it }
    val pointList = Array(n + 1) {
        if (it == 0) Point(0.0, 0.0)
        else {
            val (x, y) = br.readLine().split(" ").map { it.toDouble() }
            Point(x, y)
        }
    }

    repeat(m) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }

        union(a, b)
    }

    val pq = PriorityQueue<Edge>()
    for (i in 1..n)
        for (j in i + 1..n)
            pq.add(Edge(i, j, distance(pointList[i], pointList[j])))

    var res = 0.0
    while (pq.isNotEmpty()) {
        val edge = pq.remove()

        if (findParent(edge.a) == findParent(edge.b)) continue

        res += edge.w
        union(edge.a, edge.b)
    }

    bw.write(String.format("%.2f", res))


    bw.close()
    br.close()
}

data class Point(val x: Double, val y: Double)

data class Edge(val a: Int, val b: Int, val w: Double) : Comparable<Edge> {
    override fun compareTo(other: Edge): Int {
        return if (w - other.w > 0.0) 1
        else -1
    }
}

fun distance(p1: Point, p2: Point): Double {
    return ((p1.x - p2.x).pow(2.0) + (p1.y - p2.y).pow(2.0)).pow(0.5)
}

fun findParent(x: Int): Int {
    if (parent[x] == x) return x

    parent[x] = findParent(parent[x])

    return parent[x]
}

fun union(a: Int, b: Int) {
    val ap = findParent(a)
    val bp = findParent(b)

    if (ap > bp)
        parent[ap] = bp
    else
        parent[bp] = ap
}