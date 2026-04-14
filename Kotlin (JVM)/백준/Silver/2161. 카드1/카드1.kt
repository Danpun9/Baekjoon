import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine().toInt()

    val q = ArrayDeque<Int>()
    for (i in 1..n) q.addFirst(i)

    for (i in 1..n) {
        bw.write("${q.removeLast()} ")
        if (q.isNotEmpty()) q.addFirst(q.removeLast())
    }

    bw.close()
    br.close()
}