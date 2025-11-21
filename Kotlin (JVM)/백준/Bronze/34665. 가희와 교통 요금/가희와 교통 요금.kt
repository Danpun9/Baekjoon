import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    if (br.readLine() == br.readLine())
        bw.write("0\n")
    else
        bw.write("1550\n")
    
    bw.close()
    br.close()
}
