import java.io.*
import java.util.PriorityQueue

lateinit var graph: Array<ArrayList<Node>>
lateinit var visited: BooleanArray

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val (n, m, r) = br.readLine().split(" ").map { it.toInt() }

    val arr = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    graph = Array(n + 1) { ArrayList() }

    repeat(r) {
        val (a, b, w) = br.readLine().split(" ").map { it.toInt() }

        graph[a].add(Node(b, w))
        graph[b].add(Node(a, w))
    }

    var res = Int.MIN_VALUE
    for (i in 1..n) {
        dijkstra(i, m)

        var cnt = 0

        for (j in 1..n)
            if (visited[j]) cnt += arr[j - 1]

        res = maxOf(res, cnt)
    }

    bw.write("$res\n")

    bw.close()
    br.close()
}

data class Node(val end: Int, val w: Int) : Comparable<Node> {
    override fun compareTo(other: Node): Int {
        return w - other.w
    }
}

fun dijkstra(start: Int, maxDist: Int) {
    val dist = IntArray(graph.size) { Int.MAX_VALUE }
    visited = BooleanArray(graph.size)

    val pq = PriorityQueue<Node>()
    dist[start] = 0
    pq.add(Node(start, 0))

    while (pq.isNotEmpty()) {
        val curr = pq.remove()

        if (visited[curr.end]) continue

        visited[curr.end] = true

        for (i in graph[curr.end]) {
            if (visited[i.end]) continue
            if (dist[i.end] < dist[curr.end] + i.w || dist[curr.end] + i.w > maxDist) continue

            dist[i.end] = dist[curr.end] + i.w
            pq.add(Node(i.end, dist[i.end]))
        }
    }
}