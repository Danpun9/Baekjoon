import java.io.*

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  val bw = BufferedWriter(OutputStreamWriter(System.`out`))

  // 입력
  val n = br.readLine().toInt()

  val A = IntArray(n)
  val B = IntArray(n)
  val C = IntArray(n)
  val D = IntArray(n)

  for (i in 0..<n) {
    val line = br.readLine().split(" ").map { it.toInt() }
    A[i] = line[0]
    B[i] = line[1]
    C[i] = line[2]
    D[i] = line[3]
  }

  // AB, CD 배열 생성
  val AB = IntArray(n * n)
  val CD = IntArray(n * n)
  var idx = 0
  for (i in 0..<n) {
    for (j in 0..<n) {
      AB[idx] = A[i] + B[j]
      CD[idx] = C[i] + D[j]
      idx++
    }
  }

  AB.sort()
  CD.sort()

  var res = 0L // n이 4000이고 원소 전부 0 -> AB.size == CD.size == 4000*4000 -> res == 4000*4000*4000*4000

  // 이분탐색
  var l = 0
  var r = n * n - 1

  while (l < n * n && r >= 0) {
    if (AB[l] + CD[r] < 0) l++
    else if (AB[l] + CD[r] > 0) r--
    else {
      var lc = 1L
      var rc = 1L

      // 같은 원소 개수 (A,B의 원소끼리 합이 같은 경우)
      while (l + 1 < n * n && AB[l] == AB[l + 1]) {
        lc++
        l++
      }
      //같은 원소 개수 (C,D의 원소끼리 합이 같은 경우)
      while (r > 0 && CD[r] == CD[r - 1]) {
        rc++
        r--
      }

      res += lc * rc
      l++
    }
  }

  // 출력
  bw.write("$res\n")

  bw.close()
  br.close()
}