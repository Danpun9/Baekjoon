import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val (n, m) = br.readLine().trim().split(" ").map { it.toInt() }

    var min6 = Int.MAX_VALUE
    var min1 = Int.MAX_VALUE

    repeat(m) {
        val (string6, string1) = br.readLine().trim().split(" ").map { it.toInt() }
        min6 = minOf(min6, string6)
        min1 = minOf(min1, string1)
    }

    min6 = minOf(min6, min1 * 6)

    val res = minOf(min6 * (n / 6) + min1 * (n % 6), min6 * (n / 6 + 1))

    bw.write("$res\n")

    bw.close()
    br.close()
}
