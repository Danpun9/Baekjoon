import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (y1, m1, d1) = br.readLine().split(" ").map { it.toInt() }
    val (y2, m2, d2) = br.readLine().split(" ").map { it.toInt() }

    val date1 = calcDay(y1, m1, d1)
    val date2 = calcDay(y2, m2, d2)

    if (y2 - y1 > 1000 || y2 - y1 == 1000 && (m2 > m1 || m2 == m1 && d2 >= d1)) bw.write("gg\n")
    else bw.write("D-${date2 - date1}\n")

    bw.close()
    br.close()
}

val day = arrayOf(0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)

fun calcDay(y: Int, m: Int, d: Int): Long {


    var cnt = 0L
    for (i in 1..<y) cnt += if (isLeapYear(i)) 366 else 365

    for (i in 1..<m) {
        cnt += if (i == 2 && isLeapYear(y)) 29
        else day[i]
    }

    cnt += d

    return cnt
}

fun isLeapYear(y: Int): Boolean {
    return y % 4 == 0 && y % 100 != 0 || y % 400 == 0
}