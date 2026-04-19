import java.io.*
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val s = br.readLine()

    val res = Array(s.length + 1) { Array(26) { 0 } }

    for (i in 1..s.length) {
        val sc = s[i - 1] - 'a'
        for (j in 0 until 26) {
            val prev = res[i - 1][j]
            res[i][j] = if (j == sc) prev + 1 else prev
        }
    }

    val q = br.readLine().toInt()

    repeat(q) {
        val st = StringTokenizer(br.readLine())

        val a = st.nextToken()[0] - 'a'
        val l = st.nextToken().toInt()
        val r = st.nextToken().toInt() + 1

        bw.write("${res[r][a] - res[l][a]}\n")
    }

    bw.close()
    br.close()
}