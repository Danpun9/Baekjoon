import java.io.*
import java.util.PriorityQueue

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    val graph = Array(n + 1) { ArrayList<Int>() }
    val inDegree = IntArray(n + 1)

    repeat(m) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }

        graph[a].add(b)
        inDegree[b]++
    }

    val q = PriorityQueue<Int>()

    for (i in 1..n)
        if (inDegree[i] == 0) q.add(i)

    while (q.isNotEmpty()) {
        val curr = q.remove()

        bw.write("$curr ")

        for (i in graph[curr]) {
            if (--inDegree[i] == 0)

                q.add(i)
        }
    }

    bw.close()
    br.close()
}