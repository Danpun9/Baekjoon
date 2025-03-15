import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val board = br.readLine().map { it == 'X' }.toBooleanArray()

    var flag = true
    var res = ""

    var idx = 0
    while (idx < board.size) {
        if (!board[idx]) {
            res += "."
            idx++
            continue
        }

        if (idx + 3 < board.size && board[idx] && board[idx + 1] && board[idx + 2] && board[idx + 3]) {
            res += "AAAA"
            idx += 4
        } else if (idx + 1 < board.size && board[idx] && board[idx + 1]) {
            res += "BB"
            idx += 2
        } else {
            flag = false
            break
        }
    }

    if (flag) bw.write(res)
    else bw.write("-1")

    bw.close()
    br.close()
}