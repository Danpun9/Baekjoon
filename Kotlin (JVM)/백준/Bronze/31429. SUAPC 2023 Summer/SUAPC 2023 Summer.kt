import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val cnt = arrayOf(0, 12, 11, 11, 10, 9, 9, 9, 8, 7, 6, 6)
    val penalty = arrayOf(0, 1600, 894, 1327, 1311, 1004, 1178, 1357, 837, 1055, 556, 773)

    val n = br.readLine().toInt()

    bw.write("${cnt[n]} ${penalty[n]}\n")

    bw.close()
    br.close()
}