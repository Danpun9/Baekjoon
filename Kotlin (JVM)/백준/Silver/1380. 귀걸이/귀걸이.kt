import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    var t = 0
    while (true) {
        t++
        val n = br.readLine().toInt()

        if (n == 0) break

        val name = Array(n) { br.readLine() }

        val ring = BooleanArray(n) { false }

        repeat(2 * n - 1) {
            val num = br.readLine().split(" ")

            ring[num[0].toInt() - 1] = !ring[num[0].toInt() - 1]
        }

        for (i in 0..<n)
            if (ring[i]) {
                bw.write("$t ${name[i]}\n")
                break
            }

    }

    bw.close()
    br.close()
}
