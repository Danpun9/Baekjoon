import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.system.exitProcess

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  val bw = BufferedWriter(OutputStreamWriter(System.`out`))

  var n = br.readLine().toInt()

  var res = ""

  if (n == 0) {
    bw.write("0\n")
    bw.flush()
    exitProcess(0)
  }

  while (n != 0) {
    if (n % -2 != 0) {
      res = "1$res"
      n = (n - 1) / -2
    } else {
      res = "0$res"
      n = n / -2
    }
  }

  bw.write("$res\n")


  bw.close()
  br.close()
}
