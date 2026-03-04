import java.io.*
import java.util.*
import kotlin.math.abs

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val t = br.readLine()?.trim()?.toInt() ?: 0

    repeat(t) {
        val st = StringTokenizer(br.readLine())
        val c1 = st.nextToken()[0]
        val r1 = st.nextToken().toInt()
        val c2 = st.nextToken()[0]
        val r2 = st.nextToken().toInt()

        val x1 = c1 - 'A'
        val y1 = r1 - 1
        val x2 = c2 - 'A'
        val y2 = r2 - 1

        // 시작점 도착점 색상 다름
        if ((x1 + y1) % 2 != (x2 + y2) % 2) {
            bw.write("Impossible\n")
        }
        // 시작점 도착점 같음
        else if (x1 == x2 && y1 == y2) {
            bw.write("0 $c1 $r1\n")
        }
        // 시작점 도착점 서로 대각선 상 위치
        else if (abs(x1 - x2) == abs(y1 - y2)) {
            bw.write("1 $c1 $r1 $c2 $r2\n")
        }
        // 시작점 - 대각선 상 아무 점 - 도착 점
        else {
            var found = false
            for (i in 0..7) {
                for (j in 0..7) {
                    if (abs(x1 - i) == abs(y1 - j) && abs(x2 - i) == abs(y2 - j)) {
                        val midC = ('A' + i)
                        val midR = j + 1
                        bw.write("2 $c1 $r1 $midC $midR $c2 $r2\n")
                        found = true
                        break
                    }
                }
                if (found) break
            }
        }
    }

    bw.close()
    br.close()
}