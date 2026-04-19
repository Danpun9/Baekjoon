import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine().toInt()

    var arr = Array(n) { br.readLine().split(" ").map { it.toInt() }.toTypedArray() }

    val q = br.readLine().toInt()

    repeat(q) {
        val cmd = br.readLine().split(" ").map { it.toInt() }.toTypedArray()

        if (cmd[0] == 1) {
            val temp = arr[cmd[1] - 1][n - 1]
            for (i in n - 1 downTo 1) arr[cmd[1] - 1][i] = arr[cmd[1] - 1][i - 1]
            arr[cmd[1] - 1][0] = temp
            
        } else if (cmd[0] == 2) {
            val tempArr = Array(n) { Array(n) { 0 } }
            for (i in 0 until n) {
                for (j in 0 until n) {
                    tempArr[j][n - 1 - i] = arr[i][j]
                }
            }

            arr = tempArr
        }
    }

    for (i in arr) {
        i.forEach { bw.write("$it ") }
        bw.write("\n")
    }
    bw.close()
    br.close()
}