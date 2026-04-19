import java.io.*
import kotlin.system.exitProcess

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    val graph = Array(n + 1) { ArrayList<Int>() }
    val inDegree = IntArray(n + 1)

    repeat(m) {
        val arr = br.readLine().split(" ").map { it.toInt() }

        for (i in 2..arr[0]) {
            graph[arr[i - 1]].add(arr[i])
            inDegree[arr[i]]++
        }
    }

    val q = ArrayDeque<Int>()

    for (i in 1..n)
        if (inDegree[i] == 0) q.addFirst(i)

    val res = ArrayList<Int>()

    for (i in 1..n) {
        if (q.isEmpty()) {
            bw.write("0")
            bw.flush()
            exitProcess(0)
        }

        val curr = q.removeLast()
        res.add(curr)

        for (j in graph[curr])
            if (--inDegree[j] == 0)
                q.addFirst(j)
    }

    res.forEach { bw.write("$it\n") }


    bw.close()
    br.close()
}