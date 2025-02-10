import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()
    val cnt = IntArray(1_000_001)
    val arr = br.readLine().split(" ").map {
        cnt[it.toInt()]++
        it.toInt()
    }.toIntArray()

    val res = IntArray(n)
    val s = ArrayDeque<Int>()

    for (i in 0..<n) {
        while (s.isNotEmpty() && cnt[arr[s.first()]] < cnt[arr[i]])
            res[s.removeFirst()] = arr[i]

        s.addFirst(i)
    }

    while (s.isNotEmpty())
        res[s.removeFirst()] = -1

    res.forEach { bw.write("$it ") }

    bw.close()
    br.close()
}