package org.example

import java.io.*
import java.util.*
import kotlin.collections.ArrayDeque

var n = 0
var m = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val st = StringTokenizer(br.readLine())

    n = st.nextToken().toInt()
    m = st.nextToken().toInt()

    val map = Array(n) { IntArray(m) { 0 } }

    for (i in 0 until n) {
        val str = br.readLine()
        for (j in 0 until m) map[i][j] = str[j].toString().toInt()
    }

    val time = Array(n) { Array(m) { Array(2) { Int.MAX_VALUE } } }

    val dx = arrayOf(0, 0, -1, 1)
    val dy = arrayOf(-1, 1, 0, 0)

    val q = ArrayDeque<Triple<Int, Int, Int>>()

    time[0][0][0] = 1
    time[0][0][1] = 1
    q.addFirst(Triple(0, 0, 1))

    var res = -1

    while (q.isNotEmpty()) {
        val (x, y, canCrush) = q.removeLast()

        if (x == m - 1 && y == n - 1) {
            res = time[y][x][canCrush]
            break
        }

        for (i in 0..3) {
            val nx = x + dx[i]
            val ny = y + dy[i]

            if (isInRange(nx, false) && isInRange(ny, true)) {
                if (map[ny][nx] == 1) {
                    if (canCrush == 1 && time[ny][nx][1] > time[y][x][canCrush] + 1) {
                        time[ny][nx][0] = time[y][x][canCrush] + 1
                        q.addFirst(Triple(nx, ny, 0))
                    }
                }

                if (map[ny][nx] == 0 && time[ny][nx][canCrush] > time[y][x][canCrush] + 1) {
                    time[ny][nx][canCrush] = time[y][x][canCrush] + 1
                    q.addFirst(Triple(nx, ny, canCrush))
                }
            }
        }

    }

    bw.write("${res}")

    bw.close()
    br.close()
}

fun isInRange(num: Int, isRow: Boolean): Boolean {
    if (isRow) {
        return num in 0 until n
    } else {
        return num in 0 until m
    }
}