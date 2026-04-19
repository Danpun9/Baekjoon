package org.example

import java.io.*
import java.util.*
import kotlin.collections.ArrayDeque


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val (n, k) = br.readLine().split(" ").map { it.toInt() }

    val visited = BooleanArray(100001)
    var min = Int.MAX_VALUE
    var cnt = 0

    val q = ArrayDeque<Pair<Int, Int>>()

    q.addFirst(Pair(n, 0))

    while (q.isNotEmpty()) {
        val (curr, time) = q.removeLast()

        visited[curr] = true

        if (curr == k) {
            if (min > time) {
                min = time
                cnt = 1
            } else if (min == time) {
                cnt++
            }
            continue
        }

        if (curr - 1 >= 0 && !visited[curr - 1]) q.addFirst(Pair(curr - 1, time + 1))
        if (curr + 1 <= 100000 && !visited[curr + 1]) q.addFirst(Pair(curr + 1, time + 1))
        if (curr * 2 <= 100000 && !visited[curr * 2]) q.addFirst(Pair(curr * 2, time + 1))
    }

    bw.write("${min}\n${cnt}")

    bw.close()
    br.close()
}