import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

lateinit var arr: IntArray // 지시 사항
lateinit var dp: Array<Array<IntArray>> // [현재 인덱스][왼발 위치][오른발 위치]

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    arr = br.readLine().split(" ").map { it.toInt() }.toIntArray()

    dp = Array(arr.size - 1) { Array(5) { IntArray(5) } }

    bw.write("${move(0, 0, 0)}")

    bw.close()
    br.close()
}

// [현재 위치][이동 위치] -> 이동 힘
val power = arrayOf(
    arrayOf(1, 2, 2, 2, 2),
    arrayOf(0, 1, 3, 4, 3),
    arrayOf(0, 3, 1, 3, 4),
    arrayOf(0, 4, 3, 1, 3),
    arrayOf(0, 3, 4, 3, 1)
)

fun move(depth: Int, l: Int, r: Int): Int {
    if (depth == arr.size - 1) return 0 // 지시사항 끝

    if (dp[depth][l][r] != 0) return dp[depth][l][r] // 이미 탐색된 부분

    val next = arr[depth] // 다음 이동 위치

    dp[depth][l][r] = minOf(
        move(depth + 1, next, r) + power[l][next], // 왼발을 다음 위치로 이동
        move(depth + 1, l, next) + power[r][next] // 오른발을 다음 위치로 이동
    )

    return dp[depth][l][r]

}