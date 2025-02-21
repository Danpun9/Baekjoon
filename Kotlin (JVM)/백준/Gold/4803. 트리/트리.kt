import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.HashSet

lateinit var parent: IntArray

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val br = BufferedReader(InputStreamReader(System.`in`))

    var t = 1
    while (true) {
        val (n, m) = br.readLine().split(" ").map { it.toInt() }

        if (n == 0 && m == 0) break

        parent = IntArray(n + 1) { it }

        for (i in 1..m) {
            val (a, b) = br.readLine().split(" ").map { it.toInt() }

            val ap = findParent(a)
            val bp = findParent(b)

            if (ap == bp) {
                if (ap != -1) parent[ap] = -1
                if (bp != -1) parent[bp] = -1
            } else {
                if (ap > bp)
                    parent[ap] = bp
                else
                    parent[bp] = ap
            }
        }

        val set = HashSet<Int>()
        for (i in 1..n) {
            set.add(findParent(i))
        }

        set.remove(-1)

        when (set.size) {
            0 -> bw.write("Case ${t++}: No trees.\n")
            1 -> bw.write("Case ${t++}: There is one tree.\n")
            else -> bw.write("Case ${t++}: A forest of ${set.size} trees.\n")
        }
    }

    bw.close()
    br.close()
}

fun findParent(x: Int): Int {
    if (parent[x] == -1) return -1

    if (parent[x] != x) parent[x] = findParent(parent[x])

    return parent[x]
}