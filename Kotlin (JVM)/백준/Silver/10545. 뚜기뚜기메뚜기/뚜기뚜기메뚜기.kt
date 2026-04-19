import java.io.*
import java.util.StringTokenizer

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val br = BufferedReader(InputStreamReader(System.`in`))

    val st = StringTokenizer(br.readLine())
    val num = Array(10) { 0 }

    for (i in 1..9) num[st.nextToken().toInt()] = i

    val str = br.readLine()

    val letter = arrayOf(2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 7, 8, 8, 8, 9, 9, 9, 9)
    val repeatL = arrayOf(1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 4, 1, 2, 3, 1, 2, 3, 4)

    var res = ""
    var prev = -1

    for (i in 0 until str.length) {
        if (prev == letter[str[i] - 'a']) res += "#"
        prev = letter[str[i] - 'a']

        repeat(repeatL[str[i] - 'a']) {
            res += num[letter[str[i] - 'a']]
        }
    }

    bw.write(res)

    bw.close()
    br.close()
}