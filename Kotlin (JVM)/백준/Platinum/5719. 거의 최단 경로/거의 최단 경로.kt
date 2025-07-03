import java.io.*
import java.util.*

lateinit var edgeList: Array<MutableList<Pair<Int, Int>>> // 인접 리스트
lateinit var parent: Array<MutableList<Int>> // 최단 경로 추적용
lateinit var visited: Array<BooleanArray> // 백트래킹 중복 제거 방지

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  val bw = BufferedWriter(OutputStreamWriter(System.`out`))

  while (true) {
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    if (n == 0 && m == 0) break

    edgeList = Array(n) { mutableListOf() }
    parent = Array(n) { mutableListOf() }
    visited = Array(n) { BooleanArray(n) }

    val (s, d) = br.readLine().split(" ").map { it.toInt() }

    repeat(m) {
      val (u, v, p) = br.readLine().split(" ").map { it.toInt() }
      edgeList[u].add(Pair(v, p))
    }

    if (dijkstra(s, d) == -1) { // S->D 경로 확인
      bw.write("-1\n")
      continue
    }
    backTracking(s, d) // 최단 경로 제거
    bw.write("${dijkstra(s, d)}\n") // 거의 최단 경로
  }

  bw.close()
  br.close()
}

// 최단 경로 제거 백트래킹
fun backTracking(start: Int, curr: Int) {
  if (start == curr) return
  for (prev in parent[curr]) {
    if (!visited[prev][curr]) {
      edgeList[prev].removeIf { it.first == curr }
      visited[prev][curr] = true
      backTracking(start, prev)
    }
  }
}

// 다익스트라
fun dijkstra(start: Int, end: Int): Int {
  val dist = IntArray(edgeList.size) { Int.MAX_VALUE }
  val pq = PriorityQueue<Pair<Int, Int>>(compareBy { it.second }) // 노드, 거리

  dist[start] = 0
  pq.add(Pair(start, 0))
  parent = Array(edgeList.size) { mutableListOf() } // parent 초기화

  while (pq.isNotEmpty()) {
    val (curr, currDist) = pq.poll()
    if (dist[curr] < currDist) continue

    for ((next, weight) in edgeList[curr]) {
      if (dist[next] > dist[curr] + weight) { // 새 최단 경로
        dist[next] = dist[curr] + weight
        pq.add(Pair(next, dist[next]))
        parent[next].clear()
        parent[next].add(curr)
      } else if (dist[next] == dist[curr] + weight) { // 기존 최단 경로랑 길이 같음
        parent[next].add(curr)
      }
    }
  }

  return if (dist[end] == Int.MAX_VALUE) -1 else dist[end]
}
