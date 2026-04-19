package org.example

import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine().toInt()

    val (p1, p2) = br.readLine().split('*')

    for (i in 1..n) {
        val str = br.readLine()

        if (str.startsWith(p1) && str.endsWith(p2) && str.length >= p1.length + p2.length) {
            bw.write("DA\n")
        } else {
            bw.write("NE\n")
        }
    }


    bw.close()
    br.close()
}