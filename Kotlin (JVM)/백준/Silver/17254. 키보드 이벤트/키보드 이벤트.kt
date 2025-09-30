import java.io.*
import java.util.PriorityQueue

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  val bw = BufferedWriter(OutputStreamWriter(System.out))

  val (n, m) = br.readLine().split(" ").map { it.toInt() }

  val pq = PriorityQueue<Keyboard>()

  for (i in 1..m) {
    val (a, b, c) = br.readLine().split(" ")
    pq.add(Keyboard(a.toInt(), b.toInt(), c))
  }

  while (pq.isNotEmpty()) {
    bw.write(pq.remove().char)
  }

  bw.close()
  br.close()
}

data class Keyboard(val idx: Int, val sec: Int, val char: String) : Comparable<Keyboard> {
  override fun compareTo(other: Keyboard): Int {
    if (sec == other.sec) return this.idx.compareTo(other.idx)
    return this.sec.compareTo(other.sec)
  }
}