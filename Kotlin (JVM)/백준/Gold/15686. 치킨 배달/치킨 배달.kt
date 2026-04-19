import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.abs
import kotlin.math.min

lateinit var chickenList: ArrayList<Pair<Int, Int>>
lateinit var houseList: ArrayList<Pair<Int, Int>>

lateinit var chickenCheck: BooleanArray

var M = 0
var res = Int.MAX_VALUE

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    chickenList = ArrayList<Pair<Int, Int>>()
    houseList = ArrayList<Pair<Int, Int>>()

    for (i in 0 until n) {
        val str = br.readLine().split(' ').map { it.toInt() }.toIntArray()
        for (j in 0 until n) {
            when (str[j]) {
                0 -> continue
                1 -> houseList.add(Pair(i, j))
                2 -> chickenList.add(Pair(i, j))
            }
        }
    }

    M = m
    chickenCheck = BooleanArray(chickenList.size)

    dfs(0, 0)

    bw.write("$res")

    bw.close()
    br.close()
}

fun dfs(minIdx: Int, depth: Int) {
    if (depth == M) {

        var sum = 0

        for (house in houseList) {
            val (y, x) = house
            var min = Int.MAX_VALUE

            for (idx in 0 until chickenCheck.size) {
                if (!chickenCheck[idx]) continue

                val (cy, cx) = chickenList[idx]
                min = min(min, abs(y - cy) + abs(x - cx))
            }

            sum += min
        }

        res = min(res, sum)
        return
    }

    for (i in minIdx until chickenList.size) {
        chickenCheck[i] = true
        dfs(i + 1, depth + 1)
        chickenCheck[i] = false
    }

}