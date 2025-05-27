import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  val bw = BufferedWriter(OutputStreamWriter(System.`out`))

  val t = br.readLine().toInt()

  repeat(t) {
    br.readLine()
    br.readLine()

    val sejun = br.readLine().split(" ").map { it.toInt() }.sorted().toIntArray()
    val sebi = br.readLine().split(" ").map { it.toInt() }.sorted().toIntArray()

    bw.write(
      if (sejun[sejun.size - 1] >= sebi[sebi.size - 1]) "S\n"
      else "B\n"
    )
  }

  bw.close()
  br.close()
}
