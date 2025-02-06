import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.PriorityQueue

lateinit var graph: Array<ArrayList<Edge>>
lateinit var dist: IntArray
lateinit var path: IntArray
lateinit var visited: BooleanArray

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()
    val m = br.readLine().toInt()

    graph = Array(n + 1) { ArrayList() }
    dist = IntArray(n + 1) { Int.MAX_VALUE }
    path = IntArray(n + 1)
    visited = BooleanArray(n + 1)

    repeat(m) {
        val (s, e, w) = br.readLine().split(" ").map { it.toInt() }

        graph[s].add(Edge(e, w))
    }

    val (start, end) = br.readLine().split(" ").map { it.toInt() }
    dijkstra(start)

    val resPath = ArrayList<Int>()
    var curr = end
    while (curr != 0) {
        resPath.add(curr)
        curr = path[curr]
    }

    bw.write("${dist[end]}\n")
    bw.write("${resPath.size}\n")
    for (i in resPath.size - 1 downTo 0) {
        bw.write("${resPath[i]} ")
    }

    bw.close()
    br.close()
}

class Edge(val e: Int, val w: Int) : Comparable<Edge> {
    override fun compareTo(other: Edge): Int {
        return w.compareTo(other.w)
    }
}

fun dijkstra(s: Int) {
    val pq = PriorityQueue<Edge>()

    pq.add(Edge(s, 0))
    dist[s] = 0
    path[s] = 0

    while (pq.isNotEmpty()) {
        val curr = pq.remove()

        if (visited[curr.e]) continue
        visited[curr.e] = true

        for (next in graph[curr.e]) {
            if (dist[next.e] <= dist[curr.e] + next.w) continue

            dist[next.e] = dist[curr.e] + next.w
            path[next.e] = curr.e
            pq.add(Edge(next.e, dist[next.e]))
        }
    }
}