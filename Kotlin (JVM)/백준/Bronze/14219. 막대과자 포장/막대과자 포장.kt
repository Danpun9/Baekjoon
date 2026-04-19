import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    if (m * n % 3 == 0) bw.write("YES")
    else bw.write("NO")

    bw.close()
    br.close()
}