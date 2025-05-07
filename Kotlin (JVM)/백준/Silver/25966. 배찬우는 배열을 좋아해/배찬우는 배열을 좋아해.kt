import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val (n, m, q) = br.readLine().split(" ").map { it.toInt() }

    val arr = Array(n) { br.readLine().split(" ").map { it.toInt() }.toIntArray() }

    repeat(q) {
        val cmd = br.readLine().split(" ").map { it.toInt() }.toIntArray()

        when (cmd[0]) {
            0 -> arr[cmd[1]][cmd[2]] = cmd[3]

            else -> {
                val temp = arr[cmd[1]]
                arr[cmd[1]] = arr[cmd[2]]
                arr[cmd[2]] = temp
            }
        }
    }

    arr.forEach { r ->
        r.forEach { bw.write("$it ") }
        bw.write("\n")
    }

    bw.close()
    br.close()
}
