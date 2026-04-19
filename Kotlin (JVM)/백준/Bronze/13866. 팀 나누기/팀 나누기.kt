import java.io.*
import kotlin.math.abs

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val br = BufferedReader(InputStreamReader(System.`in`))

    val arr = br.readLine().split(' ').map { it.toInt() }.toTypedArray()

    arr.sort()

    bw.write("${abs((arr[0] + arr[3]) - (arr[1] + arr[2]))}")

    bw.close()
    br.close()
}
