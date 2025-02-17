import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

var C = 0

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (n, c) = br.readLine().split(" ").map { it.toInt() }
    C = c

    val arr = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    val weight1 = arr.copyOfRange(0, n / 2)
    val weight2 = arr.copyOfRange(n / 2, n)

    val sum1 = ArrayList<Int>()
    val sum2 = ArrayList<Int>()

    dfs(0, 0, weight1, sum1)
    dfs(0, 0, weight2, sum2)

    sum2.sort()
    var res = 0
    for (i in sum1) {
        val search = C - i
        res += binarySearch(sum2, search) + 1
    }

    bw.write("$res")

    bw.close()
    br.close()
}

fun dfs(idx: Int, sum: Int, weightArr: IntArray, sumArr: ArrayList<Int>) {
    if (sum > C) return
    if (idx == weightArr.size) {
        sumArr.add(sum)
        return
    }

    dfs(idx + 1, sum + weightArr[idx], weightArr, sumArr)
    dfs(idx + 1, sum, weightArr, sumArr)
}

fun binarySearch(sum: ArrayList<Int>, search: Int): Int {
    var l = 0
    var r = sum.size - 1

    var res = -1

    while (l <= r) {
        val mid = (r + l) / 2

        if (sum[mid] <= search) {
            res = mid
            l = mid + 1
        } else r = mid - 1
    }

    return res
}