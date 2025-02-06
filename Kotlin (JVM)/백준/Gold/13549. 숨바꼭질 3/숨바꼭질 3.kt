package org.example

import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    var (n, k) = br.readLine().split(" ").map { it.toInt() }

    val time = Array(100001) { Int.MAX_VALUE }

    val q: Deque<Int> = ArrayDeque()

    q.addFirst(n)
    time[n] = 0

    while (q.isNotEmpty()) {
        val cur = q.removeLast();

        if (cur == k) break

        if (cur - 1 >= 0 && time[cur - 1] > time[cur] + 1) {
            time[cur - 1] = time[cur] + 1
            q.addFirst(cur - 1)
        }
        if (cur + 1 <= 100000 && time[cur + 1] > time[cur] + 1) {
            time[cur + 1] = time[cur] + 1
            q.addFirst(cur + 1)
        }
        if (cur * 2 <= 100000 && time[cur * 2] > time[cur]) {
            time[cur * 2] = time[cur]
            q.addFirst(cur * 2)
        }
    }

    bw.write("${time[k]}")

    bw.close()
    br.close()
}