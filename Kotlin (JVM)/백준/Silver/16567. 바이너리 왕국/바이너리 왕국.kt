import java.io.*
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    val arr = IntArray(n + 2)

    val st = StringTokenizer(br.readLine())
    for (i in 1..n) arr[i] = st.nextToken().toInt()

    var flipCnt = 0
    for (i in 1..n)
        if (arr[i] == 1 && arr[i - 1] == 0)
            flipCnt++

    for (i in 1..m) {
        val cmd = br.readLine().split(" ").map { it.toInt() }.toIntArray()

        if (cmd[0] == 0)
            bw.write("$flipCnt\n")
        else {
            val idx = cmd[1]

            if (arr[idx] == 1) continue

            arr[idx] = 1

            val left = arr[idx - 1]
            val right = arr[idx + 1]

            when {
                left == 0 && right == 0 -> flipCnt++
                left == 1 && right == 1 -> flipCnt--
            }
        }
    }

    bw.close()
    br.close()
}