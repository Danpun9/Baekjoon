import java.io.*
import kotlin.system.exitProcess

data class Node(val start: Int, val end: Int) : Comparable<Node> {
    override fun compareTo(other: Node): Int {
        return this.end - other.end
    }
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    val arr = ArrayList<Node>()

    for (i in 0..<n) {
        val (x, y) = br.readLine().split(" ").map { it.toInt() }

        if (x <= y) continue // 정방향

        arr.add(Node(x, y)) // 역방향
    }

    // 역방향만 모은 배열을 도착지를 오름차순으로 정렬
    arr.sort()

    // 결과는 길이 m(0에서 m 까지의 거리) + 역방향으로 이동하는 길*2(왕복)
    var res = m.toLong()

    // 모든 경로가 정방향이면
    if (arr.isEmpty()) {
        bw.write("$m\n")
        bw.close()
        exitProcess(0)
    }

    var min = arr[0].end // 역방향의 도착
    var max = arr[0].start // 역 방향의 시작

    for (curr in arr) {
        if (curr.end <= max) max = maxOf(max, curr.start) // 현재 역방향의 도착 지점이 이전 역방향 경로에 속하면 역방향 경로의 시작부분을 수정
        else { // 역방향 경로에 속하지 않음
            res += (2 * (max - min)).toLong()
            min = curr.end
            max = curr.start
        }
    }
    res += (2 * (max - min)).toLong() // 마지막 연산

    bw.write("$res\n")

    bw.close()
    br.close()
}
