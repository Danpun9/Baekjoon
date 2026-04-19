package org.example

import java.io.*
import java.util.*

var n = 0
var m = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine().toInt()

    var re = 0
    var dy = 0

    fun recursion(n: Int): Int {
        if (n == 1 || n == 2) {
            re++
            return 1
        } else {
            return recursion(n - 1) + recursion(n - 2)
        }
    }

    fun dynamic(n: Int) {
        val fib = Array<Int>(n + 1) { 0 }

        fib[1] = 1
        fib[2] = 1

        for (i in 3..n) {
            dy++
            fib[i] = fib[i - 1] + fib[i - 2]
        }
    }

    recursion(n)
    dynamic(n)

    bw.write("${re} ${dy}")

    bw.close()
    br.close()
}