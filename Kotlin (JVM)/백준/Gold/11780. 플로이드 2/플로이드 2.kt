import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

lateinit var graph: Array<IntArray> // 비용
lateinit var mid: Array<IntArray> // 중간 우회 노드
lateinit var path: ArrayDeque<Int> // 경로

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val br = BufferedReader(InputStreamReader(System.`in`))

    // 입력 및 변수 세팅
    val n = br.readLine().toInt()
    val m = br.readLine().toInt()

    graph = Array(n + 1) { r -> IntArray(n + 1) { if (r == it) 0 else 10_000_001 } }
    mid = Array(n + 1) { IntArray(n + 1) }

    repeat(m) {
        val (a, b, w) = br.readLine().split(" ").map { it.toInt() }

        graph[a][b] = minOf(graph[a][b], w)
    }

    // 플로이드 와샬
    for (k in 1..n) {
        for (i in 1..n) {
            for (j in 1..n) {
                if (graph[i][j] <= graph[i][k] + graph[k][j]) continue // 우회 경로가 더 긺 -> 우회 경로 적용x

                graph[i][j] = graph[i][k] + graph[k][j] // 우회 경로 적용o
                mid[i][j] = k // i->j로 갈 때 k를 우회하는 것을 표시
            }
        }
    }

    // n줄 출력 (i->j 까지 비용 출력)
    for (i in 1..n) {
        for (j in 1..n) {
            bw.write(if (graph[i][j] == 10_000_001) "0 " else "${graph[i][j]} ")
        }
        bw.write("\n")
    }

    // n*n줄 출력 (i-j 까지 경로 출력)
    for (i in 1..n) {
        for (j in 1..n) {
            if (graph[i][j] == 10_000_001 || i == j) bw.write("0") // 경로 없음 || 출발==도착
            else {
                path = ArrayDeque()
                findPath(i, j)
                bw.write("${path.size} ")
                while (path.isNotEmpty()) bw.write("${path.removeFirst()} ")
            }
            bw.write("\n")
        }
    }

    bw.close()
    br.close()
}

// 경로 찾기
fun findPath(x: Int, y: Int) {
    if (mid[x][y] == 0) { // x->y 경로가 최단 거리일 때(우회 노드가 없을 때)
        path.addLast(x)
        path.addLast(y)
        return
    }

    findPath(x, mid[x][y]) // x->우회 노드
    path.removeLast()
    findPath(mid[x][y], y) // 우회 노드->y
}