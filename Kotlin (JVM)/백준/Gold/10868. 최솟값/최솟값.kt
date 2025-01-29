import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

lateinit var arr: IntArray
lateinit var tree: IntArray

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    arr = IntArray(n + 1) { if (it == 0) 0 else br.readLine().toInt() }
    tree = IntArray(n * 4)

    init(1, n, 1)

    repeat(m) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }

        bw.write("${find(1, n, 1, a, b)}\n")
    }

    bw.close()
    br.close()
}

fun init(start: Int, end: Int, idx: Int): Int {
    if (start == end) {
        tree[idx] = arr[start]
        return tree[idx]
    }

    val mid = (start + end) / 2
    tree[idx] = minOf(init(start, mid, idx * 2), init(mid + 1, end, idx * 2 + 1))
    return tree[idx]
}

fun find(start: Int, end: Int, idx: Int, left: Int, right: Int): Int {
    if (left > end || right < start) return Int.MAX_VALUE

    if (left <= start && end <= right) return tree[idx]

    val mid = (start + end) / 2

    return minOf(find(start, mid, idx * 2, left, right), find(mid + 1, end, idx * 2 + 1, left, right))
}