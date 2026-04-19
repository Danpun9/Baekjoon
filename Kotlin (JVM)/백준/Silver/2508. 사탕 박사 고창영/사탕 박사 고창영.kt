package org.example

import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    var t = br.readLine().toInt()

    while (t-- > 0) {
        br.readLine()
        val (r, c) = br.readLine().split(" ").map { it.toInt() }

        val box = Array(r) { br.readLine().toCharArray() }
        var res = 0

        for (y in 0 until r) {
            for (x in 0 until c) {
                if (box[y][x].toInt() == 111) {
                    if (x - 1 >= 0 && x + 1 < c && box[y][x - 1].toInt() == 62 && box[y][x + 1].toInt() == 60) res++
                    if (y - 1 >= 0 && y + 1 < r && box[y - 1][x].toInt() == 118 && box[y + 1][x].toInt() == 94) res++
                }
            }
        }

        bw.write("$res\n")
    }

    bw.close()
    br.close()
}