import java.io.*
import kotlin.system.exitProcess

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  val bw = BufferedWriter(OutputStreamWriter(System.`out`))

  val n = br.readLine().split(" ").map { it.toInt() }.toIntArray()

  for (i in n) {
    if (i == 0 || i == 1) continue

    bw.write("F\n")
    bw.flush()
    exitProcess(0)
  }

  bw.write("S\n")

  bw.close()
  br.close()
}
