import java.io.*

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()
    val str1 = br.readLine()
    val str2 = br.readLine()

    var success = true

    if (n % 2 == 0) {
        success = str1 == str2
    } else {
        for (i in 0 until str1.length) {
            if (str1[i] != str2[i]) continue
            success = false
            break
        }
    }

    bw.write(if (success) "Deletion succeeded" else "Deletion failed")

    bw.close()
    br.close()
}
