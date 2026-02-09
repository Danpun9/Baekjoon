import java.io.*

val br = BufferedReader(InputStreamReader(System.`in`))
val bw = BufferedWriter(OutputStreamWriter(System.`out`))

var n = 0
val memo = HashMap<String, Int>()

fun main() {


    n = br.readLine().toInt()

    var l = 0
    var r = n
    var resIdx = 0

    while (l <= r) {
        val mid = (l + r) / 2

        if (mid == 0) {
            resIdx = maxOf(resIdx, mid)
            l = mid + 1
            continue
        }

        val valA = query('A', mid)
        val valBNext = query('B', n - mid + 1)

        if (valA <= valBNext) {
            resIdx = mid
            l = mid + 1
        } else {
            r = mid - 1
        }
    }

    val finalA = query('A', resIdx)
    val finalB = query('B', n - resIdx)

    bw.write("! ${maxOf(finalA, finalB)}\n")
    bw.flush()

    bw.close()
    br.close()
}

fun query(type: Char, idx: Int): Int {
    if (idx < 1) return -1
    if (idx > n) return 2_000_000_001

    val key = "$type / $idx"
    if (memo.containsKey(key)) return memo[key]!!

    bw.write("? $type $idx\n")
    bw.flush()

    val resp = br.readLine().toInt()
    memo[key] = resp
    return resp
}