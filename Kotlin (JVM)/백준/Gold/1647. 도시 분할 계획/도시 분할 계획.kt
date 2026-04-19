import java.io.*
import java.util.PriorityQueue

lateinit var parent: IntArray

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    parent = IntArray(n + 1) { it }

    val pq = PriorityQueue<Road>()

    repeat(m) {
        val (a, b, w) = br.readLine().split(" ").map { it.toInt() }

        pq.add(Road(a, b, w))
    }

    var lastW = 0

    var res = 0

    while (pq.isNotEmpty()) {
        val curr = pq.remove()

        val ap = findParent(curr.a)
        val bp = findParent(curr.b)

        if (ap == bp) continue

        if (ap > bp) parent[ap] = bp
        else parent[bp] = ap

        res += curr.w

        lastW = curr.w
    }

    res -= lastW

    bw.write("$res")

    bw.close()
    br.close()
}

class Road(val a: Int, val b: Int, val w: Int) : Comparable<Road> {
    override fun compareTo(other: Road): Int {
        return w - other.w
    }
}

fun findParent(x: Int): Int {
    if (x == parent[x]) return x

    parent[x] = findParent(parent[x])

    return parent[x]
}