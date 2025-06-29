import java.io.*
import java.util.*
import kotlin.collections.ArrayList

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  val bw = BufferedWriter(OutputStreamWriter(System.`out`))

  // 입력
  val n = br.readLine().toInt()

  val line = ArrayList<ArrayList<Int>>()
  for (i in 0..<n) {
    val (a, b) = br.readLine().split(" ").map { it.toInt() }
    line.add(ArrayList())
    line[i].add(a) // 전선 시작 (a)
    line[i].add(b) // 전선 끝 (b)
  }

  // 전선의 끝(b)을 오름차순 정렬
  line.sortWith { o1, o2 -> o1[1] - o2[1] }

  val index = ArrayList<Int>() // 각 전선이 LIS 에서 위치하는 인덱스 리스트
  val lis = ArrayList<Int>() // 증가하는 부분 수열 리스트

  // LIS
  for (i in 0..<line.size) {
    val v = line[i] // 현재 전선
    val idx = -1 * Collections.binarySearch(lis, v[0]) - 1 // 현재 전선의 시작이  lis 에 들어갈 위치

    if (lis.isNotEmpty() && v[0] < lis[lis.size - 1]) lis.removeAt(idx) // lis에서 위치 교체

    lis.add(idx, v[0]) // 해당 인덱스에 전선 삽입
    index.add(idx) // lis에 해당되는 전선의 리스트
  }

  // 제거할 전선 수 == 전체 전선 - lis 길이
  bw.write("${n - lis.size}\n")

  val res = ArrayList<Int>() // 제거될 전선 리스트
  var lisSize = lis.size - 1 // lis의 마지막 인덱스

  for (i in line.size - 1 downTo 0) {
    if (index[i] == lisSize) lisSize-- // lis에 포함된 전선
    else res.add(line[i][0]) // lis에 포함되지 않은 전선
  }

  // 정렬 후 출력
  res.sorted().forEach { bw.write("$it\n") }

  bw.close()
  br.close()
}