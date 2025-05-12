import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    var flag = true

    for (i in 1..m) {
        if (!flag) break

        val k = br.readLine().toInt()

        val arr = br.readLine().split(" ").map { it.toInt() }.toIntArray()
        val sortedArr = arr.sorted().reversed().toIntArray()

        for (idx in arr.indices) {
            if (arr[idx] == sortedArr[idx]) continue

            flag = false
            break
        }
    }

    bw.write(if (flag) "Yes\n" else "No\n")

    bw.close()
    br.close()
}
