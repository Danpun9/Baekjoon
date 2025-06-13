import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  val bw = BufferedWriter(OutputStreamWriter(System.`out`))


  repeat(br.readLine().toInt()) {
    val (a, b) = br.readLine().split(" ").map { it.toInt() }

    if (b == 0 && a % 2 != 0) bw.write("no\n")
    else bw.write("yes\n")
  }

  bw.close()
  br.close()
}
