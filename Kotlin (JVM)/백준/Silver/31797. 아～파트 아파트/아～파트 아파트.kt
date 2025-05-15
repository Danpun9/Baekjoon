import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  val bw = BufferedWriter(OutputStreamWriter(System.`out`))

  var (n, m) = br.readLine().split(" ").map { it.toInt() }
  val arr = ArrayList<Node>()
  arr.add(Node(0, 0))
  for (idx in 1..m) {
    val (h1, h2) = br.readLine().split(" ").map { it.toInt() }

    arr.add(Node(idx, h1))
    arr.add(Node(idx, h2))
  }

  arr.sort()

  while (n > m * 2) n -= m * 2

  bw.write("${arr[n].idx}\n")

  bw.close()
  br.close()
}

data class Node(val idx: Int, val j: Int) : Comparable<Node> {
  override fun compareTo(other: Node): Int {
    return this.j - other.j
  }
}