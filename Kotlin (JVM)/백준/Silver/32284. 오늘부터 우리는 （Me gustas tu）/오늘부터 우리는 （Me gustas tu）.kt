import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val (b, a) = br.readLine().split(" ").map { it.toInt() }

    val arr = Array(n) { Array(m) { "" } }



    for (i in 0 until n) {
        val mode = if (i == b) "mid" else if (i < b) "down" else "up"

        for (j in 0 until m) {
            when (mode) {
                "down" -> arr[i][j] = "S"
                "up" -> arr[i][j] = "N"
                "mid" -> {
                    if (j <= a) arr[i][j] = "E" else arr[i][j] = "W"
                }
            }
        }
    }

    arr.forEach {
        it.forEach { direction -> bw.write(direction) }
        bw.write("\n")
    }

    bw.close()
    br.close()
}