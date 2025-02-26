import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    val graph = Array(n) { IntArray(m) }
    val idxMap = HashMap<Int, Int>()
    for (i in 0 until n) {
        val arr = br.readLine().split(" ").map { it.toInt() }.toIntArray()
        for (j in 0 until m) {
            graph[i][j] = arr[j]
            idxMap[arr[j]] = j
        }
    }

    graph[0].sort()
    val sortIdx = IntArray(m)
    for (i in 0 until m)
        sortIdx[i] = idxMap[graph[0][i]]!!

    var success = true
    for (i in 1 until n) {
        if (!success) break

        graph[i].sort()
        for (j in 0 until m) {
            if (sortIdx[j] == idxMap[graph[i][j]]!!) continue

            success = false
            break
        }
    }

    graph.sortWith { o1, o2 -> o1[0] - o2[0] }

    for (i in 0 until n - 1) {
        if (!success) break

        if (graph[i][m - 1] + 1 == graph[i + 1][0]) continue
        success = false
        break
    }

    bw.write(if (success) "1\n" else "0\n")

    bw.close()
    br.close()
}