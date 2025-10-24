import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    val paint100 = Array(101) { IntArray(101) { 0 } }

    for (i in 1..n) {
        val (x1, y1, x2, y2) = br.readLine().split(" ").map { it.toInt() }

        for (x in x1..x2) {
            for (y in y1..y2) {
                paint100[y][x]++
            }
        }
    }

    var res = 0

    for (x in 1..100)
        for (y in 1..100)
            if (paint100[y][x] > m)
                res++

    bw.write("$res\n")

    bw.close()
    br.close()
}