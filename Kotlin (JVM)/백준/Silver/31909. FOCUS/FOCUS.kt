package org.example

import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val key = IntArray(8) { it }

    val n = br.readLine().toInt()

    val arr = br.readLine().split(" ").map { it.toInt() }

    val k = br.readLine().toInt()

    for (i in 0 until n) {
        val str = Integer.toBinaryString(arr[i])

        if (str.toInt() <= 10) {
            continue
        }

        var idx1 = str.length - 1
        var idx2 = -1
        var flag = false

        for (j in idx1 downTo 1) {
            if (str[j] == '0') {
                continue
            }

            if (idx2 == -1) {
                idx2 = idx1 - j
                continue
            }

            flag = true
            break
        }

        if (flag || idx2 == -1) {
            continue
        }

        val temp = key[idx1]
        key[idx1] = key[idx2]
        key[idx2] = temp
    }

    bw.write("${key[k]}")

    bw.close()
    br.close()
}