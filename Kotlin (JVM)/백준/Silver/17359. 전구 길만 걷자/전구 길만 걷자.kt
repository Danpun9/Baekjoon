import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.min

lateinit var isStartOn: Array<Boolean>
lateinit var isEndOn: Array<Boolean>
lateinit var changeCnt: Array<Int>
lateinit var visited: Array<Boolean>

var n = 0

var res = Int.MAX_VALUE

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    n = br.readLine().toInt()

    isStartOn = Array(n) { false }
    isEndOn = Array(n) { false }
    changeCnt = Array(n) { 0 }
    visited = Array(n) { false }

    for (i in 0 until n) {
        val str = br.readLine()
        isStartOn[i] = str[0] == '1'
        isEndOn[i] = str[str.length - 1] == '1'

        for (j in 1 until str.length)
            if (str[j] != str[j - 1]) changeCnt[i]++
    }

    dfs(0, false, 0)

    bw.write("$res")

    bw.close()
    br.close()
}

fun dfs(cnt: Int, prevIsOn: Boolean, depth: Int) {
    if (depth == n) {
        res = min(res, cnt)
        return
    }

    for (i in 0 until n) {
        if (!visited[i]) {
            var isDiff = false
            if (depth != 0) isDiff = prevIsOn != isStartOn[i]

            visited[i] = true
            if (!isDiff) dfs(cnt + changeCnt[i], isEndOn[i], depth + 1)
            else dfs(cnt + 1 + changeCnt[i], isEndOn[i], depth + 1)
            visited[i] = false
        }
    }
}