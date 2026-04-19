import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

lateinit var parent: IntArray
var N = 0

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    parent = IntArray(n) { it }

    var res = 0

    for (i in 1..m) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }

        val ap = findParent(a)
        val bp = findParent(b)

        if (ap == bp) {
            res = i
            break
        }

        if (ap > bp) parent[bp] = ap
        else parent[ap] = bp
    }

    bw.write("$res")

    bw.close()
    br.close()
}

fun findParent(x: Int): Int {
    if (parent[x] == x) return x

    parent[x] = findParent(parent[x])
    return parent[x]
}