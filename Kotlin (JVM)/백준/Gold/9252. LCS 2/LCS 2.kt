package org.example

import java.io.*
import java.util.*
import kotlin.math.max

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val str1: String = br.readLine()
    val str2: String = br.readLine()

    val dp = Array(str1.length + 1) { Array<Int>(str2.length + 1) { 0 } }

    for (c1 in 1..str1.length) {
        for (c2 in 1..str2.length) {
            if (str1[c1 - 1] == str2[c2 - 1]) {
                dp[c1][c2] = dp[c1 - 1][c2 - 1] + 1
            } else {
                dp[c1][c2] = max(dp[c1 - 1][c2], dp[c1][c2 - 1])
            }
        }
    }

    bw.write("${dp[str1.length][str2.length]}\n")

    if (dp[str1.length][str2.length] > 0) {
        var c1 = str1.length
        var c2 = str2.length
        var str: String = ""

        while (true) {
            if (c1 == 0 || c2 == 0) break
            else if (dp[c1 - 1][c2] == dp[c1][c2]) c1--
            else if (dp[c1][c2 - 1] == dp[c1][c2]) c2--
            else {
                str = str1[--c1] + str
                c2--
            }
        }

        bw.write("$str\n")
    }

    bw.close()
    br.close()
}


