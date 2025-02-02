import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

lateinit var parent: IntArray

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val (n, m) = br.readLine().split(' ').map { it.toInt() }

    parent = IntArray(n + 1) { it }

    for (i in 0 until m) {
        val (cmd, a, b) = br.readLine().split(' ').map { it.toInt() }

        val ap = findParent(a)
        val bp = findParent(b)

        when (cmd) {
            0 -> {
                if (ap == bp) continue
                if (ap > bp) parent[ap] = bp
                else parent[bp] = ap
            }


            1 -> {
                if (ap == bp)
                    bw.write("YES\n")
                else
                    bw.write("NO\n")
            }
        }
    }

    bw.close()
    br.close()
}

fun findParent(x: Int): Int {
    if (x == parent[x]) return x

    parent[x] = findParent(parent[x])

    return parent[x]
}