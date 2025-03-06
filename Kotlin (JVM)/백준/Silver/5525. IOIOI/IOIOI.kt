import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine().toInt()

    val m = br.readLine().toInt()

    val str = br.readLine()

    var res = 0
    var cnt = 0
    var flag = false

    for (i in 1..<m - 1) {
        if (flag) {
            flag = false
            continue
        }

        if (str[i - 1] == 'I' && str[i] == 'O' && str[i + 1] == 'I') {
            cnt++

            if (cnt == n) {
                res++
                cnt--
            }
            flag = true
        } else cnt = 0
    }

    bw.write("$res\n")

    bw.close()
    br.close()
}