import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (v, e) = br.readLine().split(" ").map { it.toInt() }

    val graph = Array(v + 1) { IntArray(v + 1) { 4000001 } }

    repeat(e) {
        val (a, b, c) = br.readLine().split(" ").map { it.toInt() }

        graph[a][b] = c
    }

    for (i in 1..v) {
        for (j in 1..v) {
            for (k in 1..v) {
                graph[i][j] = minOf(graph[i][j], graph[i][k] + graph[k][j])
            }
        }
    }

    var res = Int.MAX_VALUE

    for (i in 1..v) {
        res = minOf(res, graph[i][i])
    }

    bw.write(if (res == 4000001) "-1" else "$res")

    bw.close()
    br.close()
}