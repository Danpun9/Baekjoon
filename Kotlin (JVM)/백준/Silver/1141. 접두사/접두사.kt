import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine().toInt()
    val words = Array(n) { br.readLine() }.sorted()

    var res = 1 // 집합의 최소 원소 개수
    for (i in 1..<n) {
        if (words[i].startsWith(words[i - 1])) continue
        res++
    }

    bw.write("$res\n")

    bw.close()
    br.close()
}
