import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val br = BufferedReader(InputStreamReader(System.`in`))

    var st = StringTokenizer(br.readLine())
    val p1 = Point(st.nextToken().toLong(), st.nextToken().toLong())
    val p2 = Point(st.nextToken().toLong(), st.nextToken().toLong())
    st = StringTokenizer(br.readLine())
    val p3 = Point(st.nextToken().toLong(), st.nextToken().toLong())
    val p4 = Point(st.nextToken().toLong(), st.nextToken().toLong())

    val l1 = ccw(p1, p2, p3) * ccw(p1, p2, p4)
    val l2 = ccw(p3, p4, p1) * ccw(p3, p4, p2)

    val c1 = minOf(p1.x, p2.x) <= maxOf(p3.x, p4.x)
    val c2 = minOf(p3.x, p4.x) <= maxOf(p1.x, p2.x)
    val c3 = minOf(p1.y, p2.y) <= maxOf(p3.y, p4.y)
    val c4 = minOf(p3.y, p4.y) <= maxOf(p1.y, p2.y)

    if (l1 == 0 && l2 == 0) { // 두 선분이 평행할 때
        if (c1 && c2 && c3 && c4) bw.write("1")
        else bw.write("0")
    } else if (l1 <= 0 && l2 <= 0) bw.write("1") // 선분 교차 1 조건
    else bw.write("0")

    bw.write("\n")

    bw.close()
    br.close()
}

data class Point(val x: Long, val y: Long)

fun ccw(p1: Point, p2: Point, p3: Point): Int {
    val res = (p1.x * p2.y) + (p2.x * p3.y) + (p3.x * p1.y) - ((p1.y * p2.x) + (p2.y * p3.x) + (p3.y * p1.x))

    return if (res > 0L) 1
    else if (res < 0L) -1
    else 0
}