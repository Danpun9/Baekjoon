import java.io.*

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  val bw = BufferedWriter(OutputStreamWriter(System.`out`))

  val n = (br.readLine().toInt() - 1) % ((5 + 10 + 15 + 20) * 2) + 1

  val loc = when {
    n <= 5 -> n
    n <= 10 -> 10 - n
    n <= 20 -> n - 10
    n <= 10 -> 10 - n
    n <= 20 -> n - 10
    n <= 30 -> 30 - n
    n <= 45 -> n - 30
    n <= 60 -> 60 - n
    n <= 80 -> n - 60
    else -> 100 - n
  }

  bw.write("${if (loc == 0) 0 else (loc - 1) / 5 + 1}\n")

  bw.close()
  br.close()
}
