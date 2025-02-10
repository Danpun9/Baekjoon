import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

lateinit var arr: IntArray
lateinit var minTree: IntArray
lateinit var maxTree: IntArray

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    arr = IntArray(n + 1) {
        if (it == 0)
            0
        else
            br.readLine().toInt()
    }

    minTree = IntArray(n * 4)
    maxTree = IntArray(n * 4)

    init(1, n, 1, true)
    init(1, n, 1, false)

    repeat(m) {
        val (s, e) = br.readLine().split(" ").map { it.toInt() }

        val min = find(1, n, 1, s, e, true)
        val max = find(1, n, 1, s, e, false)

        bw.write("$min $max\n")
    }

    bw.close()
    br.close()
}

fun init(start: Int, end: Int, idx: Int, isMin: Boolean): Int {
    if (start == end) {
        if (isMin)
            minTree[idx] = arr[start]
        else
            maxTree[idx] = arr[start]

        return arr[start]
    }

    val mid = (start + end) / 2

    return if (isMin) {
        minTree[idx] = minOf(init(start, mid, idx * 2, isMin), init(mid + 1, end, idx * 2 + 1, isMin))
        minTree[idx]
    } else {
        maxTree[idx] = maxOf(init(start, mid, idx * 2, isMin), init(mid + 1, end, idx * 2 + 1, isMin))
        maxTree[idx]
    }
}

fun find(start: Int, end: Int, idx: Int, left: Int, right: Int, isMin: Boolean): Int {
    if (left > end || right < start)
        return if (isMin) Int.MAX_VALUE else Int.MIN_VALUE

    if (left <= start && right >= end)
        return if (isMin) minTree[idx] else maxTree[idx]

    val mid = (start + end) / 2

    return if (isMin) {
        minOf(find(start, mid, idx * 2, left, right, isMin), find(mid + 1, end, idx * 2 + 1, left, right, isMin))
    } else {
        maxOf(find(start, mid, idx * 2, left, right, isMin), find(mid + 1, end, idx * 2 + 1, left, right, isMin))
    }
}