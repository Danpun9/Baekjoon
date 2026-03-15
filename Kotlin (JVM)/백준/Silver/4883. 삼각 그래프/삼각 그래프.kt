import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    var test = 1
    while (true) {
        val n = br.readLine().toInt()

        if (n == 0) break

        val graph = Array(n) { br.readLine().split(" ").map { it.toLong() }.toLongArray() }

        graph[0][0] = 1_000_000_000L
        graph[0][2] += graph[0][1]

        for (i in 1..<n) {
            graph[i][0] += minOf(graph[i - 1][0], graph[i - 1][1])

            graph[i][1] += minOf(
                minOf(graph[i - 1][0], graph[i - 1][1]),
                minOf(graph[i - 1][2], graph[i][0])
            )

            graph[i][2] += minOf(graph[i - 1][1], graph[i - 1][2], graph[i][1])
        }

        bw.write("${test++}. ${graph[n - 1][1]}\n")
    }

    bw.close()
    br.close()
}