import java.io.*
import java.util.PriorityQueue

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  val bw = BufferedWriter(OutputStreamWriter(System.`out`))

  val n = br.readLine().toInt()
  var dasom = br.readLine().toInt()

  val pq = PriorityQueue<Int>(reverseOrder())

  for (i in 1..n - 1) pq.add(br.readLine().toInt())

  var res = 0
  while (pq.isNotEmpty() && pq.peek() >= dasom) {
    pq.add(pq.remove() - 1)
    dasom++
    res++
  }

  bw.write("$res\n")

  bw.close()
  br.close()
}