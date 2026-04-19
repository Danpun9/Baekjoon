import java.io.*

lateinit var map: Array<IntArray> // 물고기 지도
var N = 0

// 현재 상어의 위치
var curr_y = 0
var curr_x = 0

var size = 2 // 상어 크기
var eat = 0 // 상어가 먹은 횟수
var time = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine().toInt()
    N = n

    map = Array(n) { br.readLine().split(" ").map { it.toInt() }.toIntArray() }

    // 지도에서 현재 상어 위치 구한 후 지도 수정
    for (i in 0 until n) {
        var isBreak = false
        for (j in 0 until n) {
            if (map[i][j] == 9) {
                curr_y = i
                curr_x = j
                map[i][j] = 0
                isBreak = true
                break
            }
        }
        if (isBreak) break
    }

    var res = 0
    while (bfs()) { // 물고기 섭취 유무
        // 상어 크기 조정
        eat++
        if (eat == size) {
            size++
            eat = 0
        }

        // 지도 수정
        map[curr_y][curr_x] = 0

        // 시간 합산
        res += time
    }

    bw.write("$res")


    bw.close()
    br.close()
}

val dy = arrayOf(0, 0, 1, -1)
val dx = arrayOf(1, -1, 0, 0)

fun bfs(): Boolean { // 물고기 섭취 유무
    val q = ArrayDeque<Triple<Int, Int, Int>>()
    val visited = Array(N) { BooleanArray(N) }
    var findMin = false

    q.addFirst(Triple(curr_y, curr_x, 0))
    visited[curr_y][curr_x] = true

    time = Int.MAX_VALUE

    while (q.isNotEmpty()) {
        val (cy, cx, ct) = q.removeLast()

        if (findMin && ct + 1 > time) continue

        for (i in 0..3) {
            val ny = cy + dy[i]
            val nx = cx + dx[i]
            val nt = ct + 1

            if (ny !in 0 until N || nx !in 0 until N) continue // 범위 벗어나면 continue
            if (visited[ny][nx]) continue // 이미 방문한 곳이면 continue
            if (map[ny][nx] > size) continue // 물고기의 사이즈가 상어보다 크면 continue

            if (map[ny][nx] == 0 || map[ny][nx] == size) { // 빈 칸 이거나 크기가 같은 물고기 칸이면 먹지 않고 이동
                q.addFirst(Triple(ny, nx, nt))
                visited[ny][nx] = true

            } else { // 먹을 수 있는 물고기면
                if (time > nt) { // 가장 가까운 물고기가 바뀌면 이동 위치 변경 및 최소시간 변경
                    visited[ny][nx] = true
                    time = nt

                    findMin = true

                    curr_y = ny
                    curr_x = nx
                } else if (time == nt) { // 가까운 물고기가 여러마리면 상단 우선, 좌측 우선
                    visited[ny][nx] = true

                    if (curr_y > ny) {
                        curr_y = ny
                        curr_x = nx
                    } else if (curr_y == ny && curr_x > nx) {
                        curr_x = nx
                    }
                }
            }
        }
    }

    return time != Int.MAX_VALUE // 물고기 섭취 유무
}
