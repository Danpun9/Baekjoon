import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val arr = br.readLine().split(" ").map { it.toInt() }.toIntArray()

    val dq = LinkedList<Int>()
    for (i in 1..n) {
        dq.add(i)
    }

    var cnt = 0

    for (num in arr) {
        val idx = dq.indexOf(num)
        val halfIdx = dq.size / 2

        if (idx <= halfIdx) {
            for (i in 0 until idx) {
                dq.addLast(dq.removeFirst())
                cnt++
            }
        } else {
            for (i in 0 until dq.size - idx) {
                dq.addFirst(dq.removeLast())
                cnt++
            }
        }

        dq.removeFirst()
    }

    bw.write("$cnt\n")

    bw.close()
    br.close()
}