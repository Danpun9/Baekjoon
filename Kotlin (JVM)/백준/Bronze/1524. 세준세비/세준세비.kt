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

    var sejun = -1
    var sebin = -1

    br.readLine().split(" ").map { sejun = maxOf(sejun, it.toInt()) }
    br.readLine().split(" ").map { sebin = maxOf(sebin, it.toInt()) }

    bw.write(
      if (sejun >= sebin) "S\n"
      else "B\n"
    )
  }

  bw.close()
  br.close()
}
