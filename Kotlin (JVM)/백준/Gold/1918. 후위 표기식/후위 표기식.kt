package org.example

import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine()

    val s: Deque<Char> = ArrayDeque()

    for (i in 0 until n.length) {
        if (n[i].isLetter()) {
            bw.write(n[i].toString());
        } else {
            if (n[i] == '(') {
                s.addFirst(n[i])
            } else if (n[i] == ')') {
                while (s.first != '(') {
                    bw.write("${s.removeFirst()}")
                }
                s.removeFirst()
            } else {
                while (s.isNotEmpty() && priority(s.first()) >= priority(n[i])) {
                    bw.write("${s.removeFirst()}")
                }
                s.addFirst(n[i])
            }
        }
    }

    while (s.isNotEmpty()) {
        bw.write("${s.removeFirst()}")
    }

    bw.close()
    br.close()
}

fun priority(c: Char): Int {
    return when (c) {
        '*', '/' -> 2
        '+', '-' -> 1
        else -> 0
    }
}