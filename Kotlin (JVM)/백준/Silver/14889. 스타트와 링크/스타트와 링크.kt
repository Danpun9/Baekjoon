package org.example

import java.io.*
import java.util.*

lateinit var arr: Array<Array<Int>>
lateinit var visited: Array<Boolean>
var n = 0
var res = Int.MAX_VALUE

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    n = br.readLine().toInt()
    arr = Array(n) { Array<Int>(n) { 0 } }
    visited = Array<Boolean>(n) { false }

    for (i in 0 until n) {
        arr[i] = br.readLine().split(" ").map { it.toInt() }.toTypedArray()
    }

    dfs(0, 0)

    bw.write("$res")

    bw.close()
    br.close()
}

fun dfs(idx: Int, depth: Int) {
    if (depth == n / 2) {
        var start = 0
        var link = 0

        for (i in 0 until n - 1) {
            for (j in i + 1 until n) {
                if (visited[i] && visited[j]) {
                    start += arr[i][j]
                    start += arr[j][i]
                } else if (!visited[i] && !visited[j]) {
                    link += arr[i][j]
                    link += arr[j][i]
                }
            }
        }

        res = Math.min(res, Math.abs(start - link))

        return
    }

    for (i in idx until n) {
        if (!visited[i]) {
            visited[i] = true
            dfs(i + 1, depth + 1)
            visited[i] = false
        }
    }
}