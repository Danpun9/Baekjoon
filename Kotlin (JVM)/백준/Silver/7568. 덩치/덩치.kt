import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine().toInt()

    val arr = Array<Node>(n) { Node(0, 0) }

    for (i in 0 until n) {
        val st = StringTokenizer(br.readLine())
        arr[i] = Node(st.nextToken().toInt(), st.nextToken().toInt())
    }

    val rank = Array(n) { 1 }

    for (i in 0 until n - 1) {
        for (j in i + 1 until n) {
            if (arr[i].compareTo(arr[j]) == 1) {
                rank[j]++
            } else if (arr[i].compareTo(arr[j]) == -1) {
                rank[i]++
            }
        }
    }

    for (i in rank) {
        bw.write("${i} ")
    }
    bw.close()
    br.close()
}

class Node(w: Int, h: Int) : Comparable<Node> {
    val weight = w
    val height = h

    override operator fun compareTo(other: Node): Int {
        if (this.weight > other.weight && this.height > other.height) {
            return 1
        } else if (this.weight < other.weight && this.height < other.height) {
            return -1
        }
        return 0
    }
}