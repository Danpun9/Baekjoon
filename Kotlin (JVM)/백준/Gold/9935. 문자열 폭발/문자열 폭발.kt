import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val str = br.readLine()
    val word = br.readLine()

    val s = Stack<Char>()

    for (i in str) {
        s.add(i)

        if (s.size >= word.length) {
            var flag = true

            for (j in 0 until word.length) {
                if (s[s.size - word.length + j] != word[j]) {
                    flag = false
                    break
                }
            }

            if (flag) {
                for (j in word) {
                    s.pop()
                }
            }
        }
    }

    val sb = StringBuilder()

    if (s.isEmpty()) {
        bw.write("FRULA\n")
    } else {
        s.forEach { sb.append(it) }

        bw.write(sb.toString())
    }

    bw.close()
    br.close()
}