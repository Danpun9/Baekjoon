import java.io.*
import java.util.PriorityQueue

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    var (n, ch, t) = br.readLine().split(" ").map { it.toInt() }

    val pq = PriorityQueue<Int>(reverseOrder())
    repeat(n) {
        pq.add(br.readLine().toInt())
    }

    var res = 0
    var success = false

    for (i in 1..t) {
        var gh = pq.remove()
        if (gh >= ch) {
            if (gh == 1) {
                pq.add(1)
                continue
            }
            res = i
            gh /= 2
            pq.add(gh)
        } else {
            pq.add(gh)
            success = true
            break
        }
    }

    if (!success && pq.peek() < ch) {
        success = true
    }

    if (success) {
        bw.write("YES\n$res")
    } else {
        bw.write("NO\n${pq.remove()}")
    }

    bw.close()
    br.close()
}
