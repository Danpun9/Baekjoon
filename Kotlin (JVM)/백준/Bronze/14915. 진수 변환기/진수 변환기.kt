import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    var (m, n) = br.readLine().trim().split(" ").map { it.toInt() }


    val nums = arrayOf("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F")
    var res = if (m == 0) "0" else ""

    while (m > 0) {
        res = nums[m % n] + res
        m /= n
    }

    bw.write(res)
    
    bw.close()
    br.close()
}