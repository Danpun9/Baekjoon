import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine().toInt()

    val s = ArrayDeque<Node>()

    var res = 0L

    for (i in 0 until n) {
        val h = br.readLine().toInt()
        val cur = Node(h, 1)

        while (s.isNotEmpty() && s.first().h <= cur.h) {
            val top = s.removeFirst()

            res += top.cnt
            if (cur.h == top.h)
                cur.cnt += top.cnt
        }

        if (s.isNotEmpty()) res++

        s.addFirst(cur)
    }

    bw.write("$res\n")

    bw.close()
    br.close()
}

data class Node(val h: Int, var cnt: Int)