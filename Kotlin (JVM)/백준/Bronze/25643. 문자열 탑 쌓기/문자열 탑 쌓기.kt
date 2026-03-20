import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    var isPossible = true
    var prev = br.readLine()

    for (i in 1..<n) {
        val curr = br.readLine()

        var flag = false

        for (i in 1..m) {
            val sub1 = prev.substring(0, i)
            val sub2 = curr.substring(m - i, m)

            if (sub1 == sub2) {
                flag = true
                break
            }
        }

        if (flag) {
            prev = curr
            continue
        }

        for (i in 1..m) {
            val sub1 = prev.substring(m - i, m)
            val sub2 = curr.substring(0, i)

            if (sub1 == sub2) {
                flag = true
                break
            }
        }

        prev = curr

        if (!flag) {
            isPossible = false
            break
        }
    }

    bw.write(if (isPossible) "1" else "0")

    bw.close()
    br.close()
}