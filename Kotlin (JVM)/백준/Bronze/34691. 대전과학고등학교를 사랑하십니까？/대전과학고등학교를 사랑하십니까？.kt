import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    while (true) {
        val str = br.readLine()

        when (str) {
            "animal" -> bw.write("Panthera tigris\n")
            "tree" -> bw.write("Pinus densiflora\n")
            "flower" -> bw.write("Forsythia koreana\n")
            "end" -> break
        }
    }

    bw.close()
    br.close()
}