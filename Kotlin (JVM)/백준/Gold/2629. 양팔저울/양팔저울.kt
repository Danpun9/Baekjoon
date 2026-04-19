import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.abs

lateinit var res: Array<BooleanArray>
lateinit var weights: IntArray // 구슬 목록

var N = 0


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    N = br.readLine().toInt()
    weights = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    res = Array(N + 1) { BooleanArray(40001) }

    dfs(0, 0)

    br.readLine()

    br.readLine().split(" ").map { bw.write(if (res[N][it.toInt()]) "Y " else "N ") }

    bw.close()
    br.close()
}

fun dfs(idx: Int, w: Int) { // idx : 추 인덱스, w :  무게
    if (res[idx][w]) return // 현재 추를 이용하여 이미 무게를 만들 수 있으면 return
    res[idx][w] = true

    if (idx == N) return

    dfs(idx + 1, w) // 현재 추 포함x 무게
    dfs(idx + 1, w + weights[idx]) // 현재 추 포함o 무게
    dfs(idx + 1, abs(w - weights[idx])) // 반대쪽에 현재 추 포함 무게
}