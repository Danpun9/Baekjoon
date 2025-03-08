import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val arr = IntArray(3) { br.readLine().toInt() }
    arr.sort()

    bw.write("${arr[1]}\n")

    bw.close()
    br.close()
}