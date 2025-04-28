import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.PriorityQueue

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine().toInt()
    val pq = PriorityQueue<Int>(reverseOrder())

    for (i in 0..<n) {
        val arr = br.readLine().split(" ").map { it.toInt() }.toIntArray()

        for (j in 0..<n) pq.add(arr[j])
    }

    for (i in 0..<n - 1) pq.remove()

    bw.write("${pq.remove()}\n")

    bw.close()
    br.close()
}
