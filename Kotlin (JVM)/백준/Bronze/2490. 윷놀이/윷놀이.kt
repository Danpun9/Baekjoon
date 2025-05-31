import java.io.*
import kotlin.system.exitProcess

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  val bw = BufferedWriter(OutputStreamWriter(System.`out`))

  repeat(3) {
    val res = br.readLine().split(" ").sumOf { it.toInt() }

    bw.write(
      when (res) {
        1 -> "C\n"
        2 -> "B\n"
        3 -> "A\n"
        4 -> "E\n"
        else -> "D\n"
      }
    )
  }
  
  bw.close()
  br.close()
}
