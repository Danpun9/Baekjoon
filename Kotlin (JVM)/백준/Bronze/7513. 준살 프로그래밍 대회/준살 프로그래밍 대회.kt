package org.example

import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val sb = StringBuilder()

    val t = br.readLine().toInt()
    for (i in 1..t) {
        sb.append("Scenario #$i:\n")

        val m = br.readLine().toInt()
        val word = Array(m) { br.readLine() }

        val n = br.readLine().toInt()
        for (j in 1..n) {
            val st = StringTokenizer(br.readLine())
            val a = st.nextToken().toInt()
            for (i in 1..a) {
                sb.append("${word[st.nextToken().toInt()]}")
            }
            sb.append("\n")
        }
        sb.append("\n")
    }

    bw.write("$sb")

    bw.close()
    br.close()
}