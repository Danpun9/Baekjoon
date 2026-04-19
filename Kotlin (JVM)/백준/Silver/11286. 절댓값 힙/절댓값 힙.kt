import java.io.*
import java.util.*
import kotlin.math.abs

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine().toInt()

    val pq = PriorityQueue<Node>()

    repeat(n) {
        val x = br.readLine().toInt()

        when (x) {
            0 -> {
                if (pq.isNotEmpty()) bw.write("${pq.remove().v}\n")
                else bw.write("0\n")
            }

            else -> pq.add(Node(x))
        }
    }

    bw.close()
    br.close()
}

class Node(val v: Int) : Comparable<Node> {
    override fun compareTo(other: Node): Int {
        if (abs(this.v) == abs(other.v)) {
            if (this.v >= other.v) return 1
            else return -1
        } else return abs(this.v) - abs(other.v)
    }
}