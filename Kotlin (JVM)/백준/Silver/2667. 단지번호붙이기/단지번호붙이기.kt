import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine().toInt()

    val map = Array<CharArray>(n) { br.readLine().toCharArray() }

    val visited = Array<BooleanArray>(n) { BooleanArray(n) { false } }

    val dx = arrayOf(1, -1, 0, 0)
    val dy = arrayOf(0, 0, 1, -1)

    val resArr = ArrayList<Int>()

    for (i in 0 until n) {
        for (j in 0 until n) {
            if (map[i][j] - '0' == 0) continue
            if (visited[i][j]) continue

            val q = ArrayDeque<Pair<Int, Int>>()

            q.addFirst(Pair(i, j))

            var res = 0
            while (q.isNotEmpty()) {
                val (y, x) = q.removeLast()

                if (x < 0 || x >= n || y < 0 || y >= n) continue
                if (visited[y][x]) continue
                visited[y][x] = true
                if (map[y][x] - '0' == 0) continue
                res++

                for (d in 0..3) {
                    val nx = x + dx[d]
                    val ny = y + dy[d]

                    q.addFirst(Pair(ny, nx))
                }
            }

            resArr.add(res)
        }
    }

    resArr.sort()

    bw.write("${resArr.size}\n")
    for (i in resArr) {
        bw.write("$i\n")
    }

    bw.close()
    br.close()
}