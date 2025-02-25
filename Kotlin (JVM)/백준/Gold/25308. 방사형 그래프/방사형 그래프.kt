import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.pow
import kotlin.math.sqrt

lateinit var arr: DoubleArray // 능력치

val visited = BooleanArray(8) // 해당 인덱스의 능력치가 그래프에 구성되었는지 판단
val stat = DoubleArray(8) // 만들어진 그래프
var res = 0 // 결과

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val br = BufferedReader(InputStreamReader(System.`in`))

    arr = br.readLine().split(" ").map { it.toDouble() }.toDoubleArray()

    dfs(0)

    bw.write("$res")

    bw.close()
    br.close()
}

fun dfs(depth: Int) {
    if (depth == 8) {
        // 8각형 그래프의 세 점을 가져와서 좌표에 배치 후 ccw 구하기
        for (i in 0..7) {
            val ay = if (i != 0) stat[i - 1] else stat[7] // (0, ay)
            val bxy = sqrt(stat[i].pow(2.0) / 2) // (bx, by)
            val cx = if (i != 7) stat[i + 1] else stat[0] // (cx, 0)

            val ccw = (cx * ay) - (bxy * ay + cx * bxy)

            if (ccw > 0) return // 해당 부분이 반시계 방향(1사분면에서 오목한 그래프)면 이 그래프는 조건을 만족하지 못함
        }

        res++
        return
    }
    
    // 그래프 구성
    for (i in 0..7) {
        if (visited[i]) continue

        visited[i] = true
        stat[depth] = arr[i]
        dfs(depth + 1)
        visited[i] = false
    }
}
