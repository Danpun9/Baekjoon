import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    while (true) {
        val str = br.readLine()

        if (str == "END") break

        bw.write("${str.reversed()}\n")
    }
    
    bw.close()
    br.close()
}