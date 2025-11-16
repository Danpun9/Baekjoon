import java.io.*
import kotlin.math.sqrt
import kotlin.math.min

// 좌표
data class Point(val x: Int, val y: Int)

private var n = 0
private lateinit var points: Array<Point>
private var totalX = 0L // 모든 점의 x좌표 합
private var totalY = 0L // 모든 점의 y좌표 합
private var minVectorLength = Double.MAX_VALUE // 최소 벡터 크기

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val t = br.readLine().toInt()
    val sb = StringBuilder()

    repeat(t) {
        n = br.readLine().toInt()
        points = Array(n) { Point(0, 0) }
        totalX = 0L
        totalY = 0L
        minVectorLength = Double.MAX_VALUE

        for (i in 0 until n) {
            val (x, y) = br.readLine().split(" ").map { it.toInt() }
            points[i] = Point(x, y)
            totalX += x
            totalY += y
        }

        // DFS
        findCombinations(0, 0, 0L, 0L)

        sb.appendLine(String.format("%.12f", minVectorLength))
    }
    bw.write(sb.toString())

    bw.close()
    br.close()
}

private fun findCombinations(index: Int, countSelected: Int, currentXSum: Long, currentYSum: Long) {
    // 1. N/2개의 점을 모두 선택
    if (countSelected == n / 2) {
        // Vx = 2 * X_E - X_total
        val vx = 2 * currentXSum - totalX
        // Vy = 2 * Y_E - Y_total
        val vy = 2 * currentYSum - totalY


        val length = sqrt((vx * vx + vy * vy).toDouble())

        // 최소값 갱신
        minVectorLength = min(minVectorLength, length)
        return
    }

    // 모든 점 확인
    if (index == n) {
        return
    }

    // 재귀

    // 남은 점을 모두 선택해도 N/2개가 안됨
    if (n - index + countSelected < n / 2) {
        return
    }

    // 현재 index의 점을 끝으로 선택
    findCombinations(
        index + 1,
        countSelected + 1,
        currentXSum + points[index].x,
        currentYSum + points[index].y
    )

    // 현재 index의 점을 시작으로 선택
    findCombinations(
        index + 1,
        countSelected,
        currentXSum,
        currentYSum
    )
}