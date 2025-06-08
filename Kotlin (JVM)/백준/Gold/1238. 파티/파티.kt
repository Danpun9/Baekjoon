import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.PriorityQueue

const val INF = 1000001
var n = 0
var m = 0
var x = 0

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  val bw = BufferedWriter(OutputStreamWriter(System.`out`))

  val input = br.readLine().split(" ").map { it.toInt() }.toIntArray()

  n = input[0]
  m = input[1]
  x = input[2]

  val arr = Array(n + 1) { ArrayList<Node>() }
  val revArr = Array(n + 1) { ArrayList<Node>() }

  repeat(m) {
    val (a, b, w) = br.readLine().split(" ").map { it.toInt() }

    arr[a].add(Node(b, w))
    revArr[b].add(Node(a, w))
  }

  val dist1 = dijkstra(arr) // x 에서 시작 노드
  val dist2 = dijkstra(revArr) // 시작 노드에서 x

  var res = -1
  for (i in 1..n) res = maxOf(res, dist1[i] + dist2[i])

  bw.write("$res\n")

  bw.close()
  br.close()
}

data class Node(val end: Int, val w: Int) : Comparable<Node> {
  override fun compareTo(other: Node): Int {
    return this.w - other.w
  }
}

fun dijkstra(arr: Array<ArrayList<Node>>): IntArray {
  val pq = PriorityQueue<Node>()

  val visited = BooleanArray(n + 1)
  val dist = IntArray(n + 1) { INF }

  dist[x] = 0

  pq.add(Node(x, 0))

  while (pq.isNotEmpty()) {
    val curr = pq.remove()

    visited[curr.end] = true

    for (next in arr[curr.end]) {
      if (visited[next.end]) continue
      if (dist[next.end] <= dist[curr.end] + next.w) continue

      dist[next.end] = dist[curr.end] + next.w
      pq.add(Node(next.end, dist[next.end]))
    }
  }

  return dist
}