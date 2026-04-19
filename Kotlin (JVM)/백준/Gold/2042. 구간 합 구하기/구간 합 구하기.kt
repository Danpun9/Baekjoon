import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

lateinit var arr: LongArray
lateinit var tree: LongArray

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val (n, m, k) = br.readLine().split(" ").map { it.toInt() }

    arr = LongArray(n + 1) {
        if (it == 0)
            0L
        else
            br.readLine().toLong()
    }

    tree = LongArray(n * 4)

    init(1, n, 1)

    repeat(m + k) {
        val (a, b, c) = br.readLine().split(" ")

        when (a) {
            "1" -> {
                val difference = c.toLong() - arr[b.toInt()]
                arr[b.toInt()] = c.toLong()
                update(1, n, 1, b.toInt(), difference)
            }

            "2" -> bw.write("${find(1, n, 1, b.toInt(), c.toInt())}\n")
        }
    }

    bw.close()
    br.close()
}

fun init(start: Int, end: Int, idx: Int): Long {
    if (start == end) {
        tree[idx] = arr[start]

        return arr[start]
    }

    val mid = (start + end) / 2

    tree[idx] = init(start, mid, idx * 2) + init(mid + 1, end, idx * 2 + 1)
    return tree[idx]
}

fun find(start: Int, end: Int, idx: Int, left: Int, right: Int): Long {
    if (left > end || right < start)
        return 0

    if (left <= start && right >= end)
        return tree[idx]

    val mid = (start + end) / 2
    return find(start, mid, idx * 2, left, right) + find(mid + 1, end, idx * 2 + 1, left, right)
}

fun update(start: Int, end: Int, idx: Int, changeIdx: Int, changeValue: Long) {
    if (changeIdx < start || changeIdx > end) return

    tree[idx] += changeValue
    if (start == end) return

    val mid = (start + end) / 2
    update(start, mid, idx * 2, changeIdx, changeValue)
    update(mid + 1, end, idx * 2 + 1, changeIdx, changeValue)
}

