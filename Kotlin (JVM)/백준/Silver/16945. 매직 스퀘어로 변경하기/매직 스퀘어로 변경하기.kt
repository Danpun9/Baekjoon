import java.io.*
import java.util.StringTokenizer
import kotlin.math.abs

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    var st = StringTokenizer("")

    val grid = IntArray(9)

    var idx = 0
    repeat(3) {
        st = StringTokenizer(br.readLine())
        while (st.hasMoreTokens()) grid[idx++] = st.nextToken().toInt()
    }

    val magicGrid = arrayOf(
        intArrayOf(8, 1, 6, 3, 5, 7, 4, 9, 2),
        intArrayOf(6, 1, 8, 7, 5, 3, 2, 9, 4),
        intArrayOf(4, 9, 2, 3, 5, 7, 8, 1, 6),
        intArrayOf(2, 9, 4, 7, 5, 3, 6, 1, 8),
        intArrayOf(8, 3, 4, 1, 5, 9, 6, 7, 2),
        intArrayOf(4, 3, 8, 9, 5, 1, 2, 7, 6),
        intArrayOf(6, 7, 2, 1, 5, 9, 8, 3, 4),
        intArrayOf(2, 7, 6, 9, 5, 1, 4, 3, 8)
    )

    var res = Int.MAX_VALUE

    for (magic in magicGrid) {
        var cost = 0
        for (i in 0..<9) cost += abs(grid[i] - magic[i])
        res = minOf(res, cost)
    }

    bw.write("$res\n")

    bw.close()
    br.close()
}
