import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

lateinit var point: Array<Pair<Long, Long>>
var n = -1

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  val bw = BufferedWriter(OutputStreamWriter(System.`out`))

  n = br.readLine().toInt()

  point = Array(n) { Pair(-1, -1) }

  for (i in 0..<n) {
    val (x, y) = br.readLine().split(" ").map { it.toLong() }

    point[i] = Pair(x, y)
  }

  bw.write("${grahamScan()}\n")

  bw.close()
  br.close()
}

fun grahamScan(): Int {
  var root = Pair(Long.MAX_VALUE, Long.MAX_VALUE)

  // 최하단 점 찾기
  for (i in point) {
    if (i.second < root.second) root = i
    else if (i.second == root.second && i.first < root.first) root = i
  }

  // root를 기준으로 반시계 방향 정렬
  point.sortWith { p1, p2 ->
    return@sortWith when (ccw(root, p1, p2)) {
      1 -> -1
      -1 -> 1
      else -> if (dist(root, p1) > dist(root, p2)) 1 else -1
    }
  }

  // 탐색
  val s = ArrayDeque<Pair<Long, Long>>()
  s.addLast(root)

  for (i in 1..<n) {
    // 세 점이 이루는 각이 시계방향이면 점 삭제
    while (s.size >= 2 && ccw(s[s.size - 2], s[s.size - 1], point[i]) <= 0)
      s.removeLast()

    s.addLast(point[i])
  }

  return s.size
}

// 외적 구하기
fun ccw(p1: Pair<Long, Long>, p2: Pair<Long, Long>, p3: Pair<Long, Long>): Int {
  val a = p1.first * p2.second + p2.first * p3.second + p3.first * p1.second
  val b = p1.first * p3.second + p2.first * p1.second + p3.first * p2.second

  return if (a - b == 0L) 0 // 직선
  else if (a - b > 0L) 1// 반시계
  else -1 // 시계
}

// 거리 계산 (비교용)
fun dist(p1: Pair<Long, Long>, p2: Pair<Long, Long>): Long {
  return (p1.first - p2.first) * (p1.first - p2.first) + (p1.second - p2.second) * (p1.second - p2.second)
}