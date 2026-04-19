import java.io.*

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val br = BufferedReader(InputStreamReader(System.`in`))

    val t = br.readLine().toInt()

    for (i in 1..t) {
        bw.write("Material Management $i\nClassification ---- End!\n")
    }

    bw.close()
    br.close()
}
