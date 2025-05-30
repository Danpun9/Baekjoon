import java.io.*
import kotlin.system.exitProcess

lateinit var matrix: Array<LongArray>
var n = 0
var mx = -1
var my = -1

var flag = true
var resSum = 0L

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  val bw = BufferedWriter(OutputStreamWriter(System.`out`))

  // 입력
  n = br.readLine().toInt()

  matrix = Array(n) { y ->
    br.readLine().split(" ").mapIndexed() { x, data ->
      if (data.toInt() == 0) {
        my = y
        mx = x
      }
      data.toLong()
    }.toLongArray()
  }

  // 검즘
  vaildColRowSum()
  vailDiagonal()

  // 검증 결과 실패
  if (!flag) {
    bw.write("-1\n")
    bw.flush()

    exitProcess(0)
  }

  // 0 값 찾기 및 대입
  var sum1 = 0L
  var sum2 = 0L
  for (i in 0..<n) {
    sum1 += matrix[my][i]
    sum2 += matrix[i][mx]
  }

  matrix[my][mx] = resSum - sum1

  // 대입 후 검증
  // 행, 열 합 검증
  sum2 += matrix[my][mx]

  if (sum2 != resSum) {
    bw.write("-1\n")
    bw.flush()

    exitProcess(0)
  }

  sum1 = 0
  sum2 = 0

  for (i in 0..<n) {
    sum1 += matrix[i][i]
    sum2 += matrix[i][n - i - 1]
  }

  if (sum1 != resSum || sum2 != resSum) {
    bw.write("-1\n")
    bw.flush()

    exitProcess(0)
  }

  bw.write("${matrix[my][mx]}\n")

  bw.close()
  br.close()
}

// 각 행, 열 합 검증
fun vaildColRowSum() {
  // 기준 값 만들기
  for (i in 0..<n) {
    if (i == my) continue
    for (j in 0..<n) resSum += matrix[i][j]
    break
  }

  for (i in 0..<n) {
    if (i == my) continue

    var sum = 0L
    for (j in 0..<n) sum += matrix[i][j]
    if (sum != resSum) {
      flag = false
      return
    }
  }

  for (i in 0..<n) {
    if (i == mx) continue

    var sum = 0L
    for (j in 0..<n) sum += matrix[j][i]
    if (sum != resSum) {
      flag = false
      return
    }
  }
}

// 대각선 합 검증
fun vailDiagonal() {
  if (!flag) return

  if (my != mx) {
    var sum = 0L
    for (i in 0..<n) sum += matrix[i][i]

    if (sum != resSum) {
      flag = false
      return
    }
  }

  if (my != n - mx - 1) {
    var sum = 0L
    for (i in 0..<n) sum += matrix[i][n - i - 1]

    if (sum != resSum) {
      flag = false
      return
    }
  }
}