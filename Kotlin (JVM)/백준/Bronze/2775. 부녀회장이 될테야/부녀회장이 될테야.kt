package org.example

import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val arr = Array(15) { Array<Int>(14) { 1 } }
    arr[0] = Array(15) { i -> i + 1 }

    for (i in 1 until 15) {
        for (j in 1 until 14) {
            arr[i][j] = arr[i][j - 1] + arr[i - 1][j]
        }
    }

    val t = br.readLine().toInt()

    for (i in 1..t) {
        val k = br.readLine().toInt()
        val n = br.readLine().toInt() - 1

        bw.write(arr[k][n].toString() + "\n")
    }

    bw.close()
    br.close()
}


