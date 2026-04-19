import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

val prev = IntArray(100_001)
val time = IntArray(100_001) { -1 }

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val (n, k) = br.readLine().split(' ').map { it.toInt() }.toIntArray()

    if (n > k) {
        bw.write("${n - k}\n")
        for (i in n downTo k) bw.write("$i ")
    } else if (n == k) {
        bw.write("0\n$k")
    } else {
        bfs(n, k)
        bw.write("${time[k]}\n")

        val s = ArrayDeque<Int>()
        var curr = k
        while (curr != n) {
            s.addFirst(prev[curr])
            curr = prev[curr]
        }

        while (s.isNotEmpty())
            bw.write("${s.removeFirst()} ")
        bw.write("$k")
    }

    bw.close()
    br.close()
}

fun bfs(n: Int, k: Int) {
    val q = ArrayDeque<Int>()

    q.addFirst(n)
    time[n] = 0

    while (q.isNotEmpty()) {
        val curr = q.removeLast()

        if (curr == k) return

        if (curr + 1 <= 100_000 && time[curr + 1] == -1) {
            time[curr + 1] = time[curr] + 1
            prev[curr + 1] = curr
            q.addFirst(curr + 1)
        }

        if (curr - 1 >= 0 && time[curr - 1] == -1) {
            time[curr - 1] = time[curr] + 1
            prev[curr - 1] = curr
            q.addFirst(curr - 1)
        }

        if (curr * 2 <= 100_000 && time[curr * 2] == -1) {
            time[curr * 2] = time[curr] + 1
            prev[curr * 2] = curr
            q.addFirst(curr * 2)
        }
    }
}