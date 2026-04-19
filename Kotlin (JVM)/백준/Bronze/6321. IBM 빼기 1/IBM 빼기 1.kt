import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val t = br.readLine().toInt()

    repeat(t) {
        val str = br.readLine()

        var res = ""
        for (i in str) {
            if (i == 'Z') res += 'A'
            else res += i + 1
        }

        bw.write("String #${it + 1}\n")
        bw.write(res + "\n\n")
    }

    bw.close()
    br.close()
}