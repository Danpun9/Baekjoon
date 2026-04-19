import java.io.*


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val t = br.readLine().toInt()

    repeat(t) {
        val (n, k) = br.readLine().split(" ").map { it.toInt() }

        val building = br.readLine().split(" ").map { it.toInt() }.toIntArray()
        val graph = Array(n) { ArrayList<Int>() }
        val inDegree = IntArray(n)

        repeat(k) {
            val (x, y) = br.readLine().split(" ").map { it.toInt() - 1 }

            graph[x].add(y)
            inDegree[y]++
        }

        val endBuildingIdx = br.readLine().toInt() - 1

        val res = IntArray(n)
        var q = ArrayDeque<Int>()

        for (i in 0..<n) {
            res[i] = building[i]
            if (inDegree[i] == 0) q.addFirst(i)
        }


        while (q.isNotEmpty()) {
            val curr = q.removeLast()

            for (i in graph[curr]) {
                res[i] = maxOf(res[i], res[curr] + building[i])
                if (--inDegree[i] == 0) q.addFirst(i)
            }
        }

        bw.write("${res[endBuildingIdx]}\n")
    }

    bw.close()
    br.close()
}