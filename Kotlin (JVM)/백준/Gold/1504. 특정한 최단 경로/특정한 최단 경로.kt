import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.PriorityQueue
import kotlin.math.min


lateinit var graph: Array<ArrayList<Node>>

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val (N, E) = br.readLine().split(' ').map { it.toInt() }

    graph = Array(N + 1) { ArrayList() }

    repeat(E) {
        val (a, b, w) = br.readLine().split(" ").map { it.toInt() }

        graph[a].add(Node(b, w))
        graph[b].add(Node(a, w))
    }

    val (v1, v2) = br.readLine().split(" ").map { it.toInt() }

    val res1 = dijkstra(1, v1) + dijkstra(v1, v2) + dijkstra(v2, N)
    val res2 = dijkstra(1, v2) + dijkstra(v2, v1) + dijkstra(v1, N)

    bw.write("${if (res1 >= 200000001 && res2 >= 200000001) -1 else min(res1, res2)}")

    bw.close()
    br.close()
}

class Node(val end: Int, val w: Int) : Comparable<Node> {
    override fun compareTo(other: Node): Int {
        return this.w - other.w
    }
}

fun dijkstra(start: Int, end: Int): Int {
    val distance = Array(graph.size) { 200000001 }
    val visited = BooleanArray(graph.size)

    val pq = PriorityQueue<Node>()

    pq.add(Node(start, 0))
    distance[start] = 0

    while (pq.isNotEmpty()) {
        val curr = pq.remove()

        if (visited[curr.end]) continue

        visited[curr.end] = true

        for (i in graph[curr.end]) {
            if (visited[i.end]) continue
            if (distance[i.end] < distance[curr.end] + i.w) continue

            distance[i.end] = distance[curr.end] + i.w
            pq.add(Node(i.end, distance[i.end]))
        }
    }

    return distance[end]
}