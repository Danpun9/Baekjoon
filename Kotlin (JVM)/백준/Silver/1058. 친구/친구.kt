import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine().toInt()
    val graph = Array(n) { br.readLine() }

    val INF = 1_000_000
    val dist = Array(n) { i ->
        IntArray(n) { j ->
            if (i == j) 0
            else if (graph[i][j] == 'Y') 1
            else INF
        }
    }

    for (k in 0 until n) {
        for (i in 0 until n) {
            for (j in 0 until n) {
                if (i == j) continue
                dist[i][j] = minOf(dist[i][j], dist[i][k] + dist[k][j])
            }
        }
    }

    var res = 0

    for (i in 0 until n) {
        var cnt = 0
        for (j in 0 until n) {
            if (i == j) continue
            if (dist[i][j] <= 2) cnt++
        }

        res = maxOf(res, cnt)
    }

    bw.write("$res\n")

    bw.close()
    br.close()
}