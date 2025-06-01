import java.io.*
import java.util.PriorityQueue

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  val bw = BufferedWriter(OutputStreamWriter(System.`out`))

  val n = br.readLine().toInt()

  val pq = PriorityQueue<Node>()

  repeat(n) {
    val (str, i, d) = br.readLine().split(" ")

    pq.add(Node(str.uppercase(), i.toInt(), d.toInt()))
  }

  var res = ""
  while (pq.isNotEmpty()) {
    val node = pq.remove()

    res += node.str[node.d - 1]
  }

  bw.write(res)

  bw.close()
  br.close()
}

data class Node(var str: String, val i: Int, val d: Int) : Comparable<Node> {
  override fun compareTo(other: Node): Int {
    return this.i - other.i
  }
}