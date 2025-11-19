import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine().toInt()

    val date = IntArray((9999 - 2000 + 1) * 12 + 1)

    for (i in 1..n) {
        val (a, b) = br.readLine().split(" ")
        val start = date2idx(a)
        val end = date2idx(b)

        // 누적합
        date[start] += 1
        date[end + 1] -= 1
    }


    var maxVal = date[0]
    var maxIdx = 0
    for (i in 1..<date.size) {
        date[i] += date[i - 1]

        // 탐색
        if (maxVal < date[i]) {
            maxVal = date[i]
            maxIdx = i
        }
    }

    bw.write(idx2date(maxIdx))

    bw.close()
    br.close()
}

fun date2idx(date: String): Int {
    val (y, m) = date.split("-").map { it.toInt() }

    return (y - 2000) * 12 + (m - 1)
}

fun idx2date(idx: Int): String {
    val y = idx / 12 + 2000
    val m = (idx % 12 + 1)

    return "$y-${if (m < 10) "0$m" else m}"
}