import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val str = br.readLine()

    val alphabet = IntArray(26)
    for (i in str)
        alphabet[i - 'a']++

    bw.write(alphabet.joinToString(separator = " "))

    bw.close()
    br.close()
}