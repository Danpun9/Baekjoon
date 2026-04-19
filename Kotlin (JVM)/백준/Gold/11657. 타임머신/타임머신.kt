import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    val edgeList = ArrayList<Edge>()
    repeat(m) {
        val (a, b, c) = br.readLine().split(" ").map { it.toInt() }

        edgeList.add(Edge(a, b, c.toLong()))
    }

    val dist = LongArray(n + 1) { Long.MAX_VALUE }

    dist[1] = 0L
    for (i in 1..n) {
        for (j in 0..<m) {
            val curr = edgeList[j]

            if (dist[curr.a] == Long.MAX_VALUE) continue

            dist[curr.b] = minOf(dist[curr.b], dist[curr.a] + curr.c)
        }
    }

    var isCycle = false

    for (i in 0..<m) {
        val curr = edgeList[i]

        if (dist[curr.a] == Long.MAX_VALUE) continue

        if (dist[curr.b] <= dist[curr.a] + curr.c) continue

        isCycle = true
        break
    }

    if (isCycle) {
        bw.write("-1")
    } else {
        for (i in 2..n) {
            if (dist[i] == Long.MAX_VALUE) bw.write("-1\n")
            else bw.write("${dist[i]}\n")
        }
    }

    bw.close()
    br.close()
}

data class Edge(val a: Int, val b: Int, val c: Long)