import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.pow

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine().toInt()

    val arr = Array(n) {
        val (x, y, v) = br.readLine().split(" ").map { it.toDouble() }
        Node(it + 1, (x.pow(2.0) + y.pow(2.0)).pow(1.0 / 2.0) / v)
    }

    arr.sort()

    arr.forEach { bw.write("${it.idx}\n") }


    bw.close()
    br.close()
}

data class Node(val idx: Int, val v: Double) : Comparable<Node> {
    override fun compareTo(other: Node): Int {

        return if (this.v != other.v) this.v.compareTo(other.v)
        else this.idx.compareTo(other.idx)
    }
}