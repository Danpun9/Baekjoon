import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val (l, r) = br.readLine().split(" ")

    var res = 0

    if (l.length == r.length) {
        for (i in 0..<l.length) {
            if (l[i] != r[i]) break
            if (l[i] == '8') res++
        }
    }

    bw.write("$res\n")

    bw.close()
    br.close()
}
