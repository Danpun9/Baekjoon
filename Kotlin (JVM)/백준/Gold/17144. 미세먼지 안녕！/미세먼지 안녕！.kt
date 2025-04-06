import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

lateinit var map: Array<IntArray> // 지도
var R = -1 // 행의 개수
var C = -1 // 열의 개수

var upAir = -1 // 공기청정기 위쪽 행 번호
var downAir = -1 // 공기청정기 아래쪽 행 번호

var res = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val (r, c, t) = br.readLine().split(" ").map { it.toInt() }
    R = r
    C = c

    map = Array(r) { row ->
        br.readLine().split(" ").map {
            if (it.toInt() == -1) { // 공기청정기 위치
                if (upAir == -1) upAir = row
                else downAir = row
            } else
                res += it.toInt() // 총 먼지량

            it.toInt()
        }.toIntArray()
    }

    // 시간만큼 돌리기
    repeat(t) {
        spreadDust()
        moveDust()
    }

    bw.write("$res\n")

    bw.close()
    br.close()
}

val dy = arrayOf(1, -1, 0, 0)
val dx = arrayOf(0, 0, 1, -1)

// 먼지 퍼트리기
fun spreadDust() {
    val spreadDust = Array(R) { IntArray(C) } // 먼지 업데이트 지도

    for (y in map.indices) {
        for (x in map[0].indices) {
            if (map[y][x] == 0 || map[y][x] == -1) continue

            val dust = map[y][x] / 5

            if (dust == 0) continue // 먼지가 퍼트려지지 않음

            for (i in 0..3) {
                val ny = y + dy[i]
                val nx = x + dx[i]

                if (ny !in map.indices || nx !in map[0].indices) continue // 범위 벗어나면 continue
                if (map[ny][nx] == -1) continue // 퍼트려질 곳에 공기청정기 있으면 continue

                // 먼지 업데이트
                spreadDust[ny][nx] += dust // 퍼트려질 곳에 더할 먼지
                spreadDust[y][x] -= dust // 원래 위치의 먼지는 줄이기
            }
        }
    }

    // 지도 업데이트
    for (y in map.indices)
        for (x in map[0].indices)
            map[y][x] += spreadDust[y][x]
}

fun moveDust() {
    // 위쪽 공기청정기 회전
    res -= map[upAir - 1][0]

    for (i in upAir - 2 downTo 0)
        map[i + 1][0] = map[i][0]

    for (i in 0..<C - 1)
        map[0][i] = map[0][i + 1]

    for (i in 0..<upAir)
        map[i][C - 1] = map[i + 1][C - 1]

    for (i in C - 1 downTo 2)
        map[upAir][i] = map[upAir][i - 1]
    map[upAir][1] = 0

    // 아래쪽 공기청정기 회전
    res -= map[downAir + 1][0]

    for (i in downAir + 1..<R - 1)
        map[i][0] = map[i + 1][0]

    for (i in 0..<C - 1)
        map[R - 1][i] = map[R - 1][i + 1]

    for (i in R - 1 downTo downAir + 1)
        map[i][C - 1] = map[i - 1][C - 1]

    for (i in C - 1 downTo 2)
        map[downAir][i] = map[downAir][i - 1]
    map[downAir][1] = 0
}