import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine().toInt()

    repeat(n) {
        bw.write("SciComLove\n")
    }
    
    bw.close()
    br.close()
}