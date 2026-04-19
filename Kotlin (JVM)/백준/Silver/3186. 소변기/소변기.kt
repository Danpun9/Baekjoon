import java.io.*

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (k, l, n) = br.readLine().split(' ').map { it.toInt() }

    val str = br.readLine()

    val res = ArrayList<Int>()

    var isUse = false
    var isFlush = false
    var useCnt = 0
    var flushCnt = 0

    for (i in 0 until n) {
        if (str[i] == '0')
            if (isUse) {
                isUse = false
                useCnt = 0
                flushCnt = 1
            } else flushCnt++
        else
            if (isUse) useCnt++
            else {
                isUse = true
                useCnt = 1
                flushCnt = 0
            }

        if (useCnt == k) isFlush = true
        if (flushCnt == l) {
            if (isFlush) {
                res.add(i + 1)
                isFlush = false
            }
            flushCnt++
        }
    }

    if (isFlush) res.add(n + l - flushCnt)
    if (res.isEmpty()) bw.write("NIKAD")
    else res.forEach { bw.write("$it\n") }

    bw.close()
    br.close()
}