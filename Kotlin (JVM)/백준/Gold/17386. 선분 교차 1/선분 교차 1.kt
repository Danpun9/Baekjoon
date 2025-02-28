import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val br = BufferedReader(InputStreamReader(System.`in`))

    var st = StringTokenizer(br.readLine())
    val P1 = Point(st.nextToken().toLong(), st.nextToken().toLong())
    val P2 = Point(st.nextToken().toLong(), st.nextToken().toLong())

    st = StringTokenizer(br.readLine())
    val P3 = Point(st.nextToken().toLong(), st.nextToken().toLong())
    val P4 = Point(st.nextToken().toLong(), st.nextToken().toLong())

    val L1 = ccw(P1, P2, P3) * ccw(P1, P2, P4)
    val L2 = ccw(P3, P4, P1) * ccw(P3, P4, P2)

    if (L1 < 0 && L2 < 0) bw.write("1\n")
    else bw.write("0\n")
    
    bw.close()
    br.close()
}

data class Point(val x: Long, val y: Long)

fun ccw(P1: Point, P2: Point, P3: Point): Int {
    val res = P1.x * P2.y + P2.x * P3.y + P3.x * P1.y - (P1.y * P2.x + P2.y * P3.x + P3.y * P1.x)

    if (res == 0L) return 0
    if (res > 0) return 1
    return -1
}