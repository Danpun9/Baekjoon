package org.example

import java.io.*
import java.util.*

var dp = Array(21) { Array(21) { IntArray(21) { 0 } } }

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    while (true) {
        var (a, b, c) = br.readLine().split(" ").map { it.toInt() }
        if (a == -1 && b == -1 && c == -1) break

        bw.write("w(${a}, ${b}, ${c}) = ${w(a, b, c)}\n")
    }

    bw.close()
    br.close()
}

fun w(a: Int, b: Int, c: Int): Int {

    if (a >= 0 && a <= 20 && b >= 0 && b <= 20 && c >= 0 && c <= 20 && dp[a][b][c] != 0) {
        return dp[a][b][c]
    }

    if (a <= 0 || b <= 0 || c <= 0) {
        return 1
    }

    if (a > 20 || b > 20 || c > 20) {
        dp[20][20][20] = w(20, 20, 20)
        return dp[20][20][20]
    }

    if (a < b && b < c) {
        dp[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c)
        return dp[a][b][c]
    }

    dp[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1)
    return dp[a][b][c]
}