import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val t = br.readLine().toInt()

    for (i in 1..t) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }

        bw.write("${bfs(a, b)}\n")
    }

    bw.close()
    br.close()
}

fun bfs(start: Int, end: Int): String {
    val q = ArrayDeque<Pair<Int, String>>()
    val visited = Array<Boolean>(10000) { false }

    q.addFirst(Pair(start, ""))
    visited[start] = true

    var res = ""

    while (q.isNotEmpty()) {
        val (curr, str) = q.removeLast()

        if (curr == end) {
            res = str
            break
        }

        val d = curr * 2 % 10000
        val s = if (curr == 0) 9999 else curr - 1
        val l = curr % 1000 * 10 + curr / 1000
        val r = curr % 10 * 1000 + curr / 10

        if (!visited[d]) {
            q.addFirst(Pair(d, str + "D"))
            visited[d] = true
        }
        if (!visited[s]) {
            q.addFirst(Pair(s, str + "S"))
            visited[s] = true
        }
        if (!visited[l]) {
            q.addFirst(Pair(l, str + "L"))
            visited[l] = true
        }
        if (!visited[r]) {
            q.addFirst(Pair(r, str + "R"))
            visited[r] = true
        }
    }

    return res
}