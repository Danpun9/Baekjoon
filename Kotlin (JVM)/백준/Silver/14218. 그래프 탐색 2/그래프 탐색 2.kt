import java.io.*
import java.util.StringTokenizer

val bw = BufferedWriter(OutputStreamWriter(System.out))


lateinit var graph: Array<ArrayDeque<Int>>

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st: StringTokenizer

    st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    graph = Array(n + 1) { ArrayDeque<Int>() }
    repeat(m) {
        st = StringTokenizer(br.readLine())
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()
        graph[a].addLast(b)
        graph[b].addLast(a)
    }

    val q = br.readLine().trim().toInt()
    repeat(q) {
        st = StringTokenizer(br.readLine())
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()
        graph[a].add(b)
        graph[b].add(a)

        bfs()
    }

    bw.close()
    br.close()
}

fun bfs() {
    val visited = IntArray(graph.size) { -1 }
    val q = ArrayDeque<Int>()

    visited[1] = 0
    q.addLast(1)

    while (q.isNotEmpty()) {
        val curr = q.removeFirst()
        val dist = visited[curr]

        for (next in graph[curr]) {
            if (visited[next] != -1) continue
            visited[next] = dist + 1
            q.addLast(next)
        }
    }

    for (i in 1..<graph.size)
        bw.write("${visited[i]} ")
    bw.write("\n")
}