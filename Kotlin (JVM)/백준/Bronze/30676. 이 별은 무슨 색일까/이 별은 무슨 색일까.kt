import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine().toInt()

    when (n) {
        in 620..780 -> bw.write("Red\n")
        in 590..<620 -> bw.write("Orange\n")
        in 570..<590 -> bw.write("Yellow\n")
        in 495..<570 -> bw.write("Green\n")
        in 450..<495 -> bw.write("Blue\n")
        in 425..<450 -> bw.write("Indigo\n")
        in 380..<425 -> bw.write("Violet\n")
    }

    bw.close()
    br.close()
}