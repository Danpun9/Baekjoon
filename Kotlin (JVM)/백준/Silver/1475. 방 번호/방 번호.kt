import java.io.*

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  val bw = BufferedWriter(OutputStreamWriter(System.`out`))

  val n = br.readLine()

  val check = IntArray(10)

  for (i in n) {
    if (i == '6' || i == '9') {
      if (check[6] <= check[9]) check[6]++
      else check[9]++
      continue
    }

    check[i - '0']++
  }

  bw.write("${check.max()}\n")

  bw.close()
  br.close()
}