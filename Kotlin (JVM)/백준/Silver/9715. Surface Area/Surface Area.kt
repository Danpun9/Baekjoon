import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val t = br.readLine().toInt()

    for (i in 1..t) {
        val (r, c) = br.readLine().split(" ").map { it.toInt() }
        val cube = Array<Array<Int>>(r) { br.readLine().toCharArray().map { it - '0' }.toTypedArray() }

        val res = solve(r, c, cube)
        bw.write("$res\n")
    }

    bw.close()
    br.close()
}

fun solve(row: Int, col: Int, cube: Array<Array<Int>>): Int {
    var res = 0

    for (i in 0 until row) {
        for (j in 0 until col) {

            // 윗면 + 아랫면
            if (cube[i][j] != 0) res += 2


            // 후면 -> 정면
            if (i == 0) res += cube[0][j]
            else if (cube[i][j] - cube[i - 1][j] > 0) res += cube[i][j] - cube[i - 1][j]


            // 정면 -> 후면
            if (i == row - 1) res += cube[row - 1][j]
            else if (cube[i][j] - cube[i + 1][j] > 0) res += cube[i][j] - cube[i + 1][j]


            // 좌측면 -> 우측면
            if (j == 0) res += cube[i][0]
            else if (cube[i][j] - cube[i][j - 1] > 0) res += cube[i][j] - cube[i][j - 1]

            // 우측면 -> 좌측면
            if (j == col - 1) res += cube[i][col - 1]
            else if (cube[i][j] - cube[i][j + 1] > 0) res += cube[i][j] - cube[i][j + 1]
        }
    }


    return res
}