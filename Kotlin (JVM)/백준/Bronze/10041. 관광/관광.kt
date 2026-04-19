import java.io.*
import kotlin.math.abs

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val (w, h, n) = br.readLine().split(" ").map { it.toInt() }

    var (prevX, prevY) = br.readLine().split(" ").map { it.toInt() }

    var res = 0

    for (i in 2..n) {
        val (x, y) = br.readLine().split(" ").map { it.toInt() }

        while (true) {
            if (prevX - x == prevY - y) { // 갈 위치가 (prevX + a, prevY + a)에 존재
                res += abs(prevX - x)
                prevX = x
                prevY = y
                break
            }

            if (prevX < x && prevY > y || prevX > x && prevY < y) { // 갈 위치가 대각선 동남 혹은  대각선 북서에 위치
                res += abs(x - prevX) + abs(prevY - y)
                prevX = x
                prevY = y
                break
            }

            if (abs(prevX - x) > abs(prevY - y)) {
                res++
                if (prevX > x) prevX--
                else prevX++
            } else {
                res++
                if (prevY > y) prevY--
                else prevY++
            }
        }
    }

    bw.write("$res\n")

    bw.close()
    br.close()
}