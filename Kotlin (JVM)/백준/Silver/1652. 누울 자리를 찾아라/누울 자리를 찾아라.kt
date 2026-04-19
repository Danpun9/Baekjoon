import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine().toInt()

    val arr = Array(n) { br.readLine() }

    var horizontal = 0
    var vertical = 0

    var i = 0
    while (i < n) {
        var j = 0
        while (j < n) {
            if (j + 1 < n && arr[i][j] == '.' && arr[i][j + 1] == '.') {
                horizontal++
                while (j + 1 < n && arr[i][j + 1] == '.') j++
            }
            j++
        }

        j = 0
        while (j < n) {
            if (j + 1 < n && arr[j][i] == '.' && arr[j + 1][i] == '.') {
                vertical++
                while (j + 1 < n && arr[j + 1][i] == '.') j++
            }
            j++
        }

        i++
    }


    bw.write("$horizontal $vertical")

    bw.close()
    br.close()
}