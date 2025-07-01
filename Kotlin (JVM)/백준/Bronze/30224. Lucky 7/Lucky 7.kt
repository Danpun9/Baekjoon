import java.io.*

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  val bw = BufferedWriter(OutputStreamWriter(System.`out`))

  var n = br.readLine().toInt()

  val isDiv7 = n % 7 == 0
  var has7 = false
  while (n > 0) {
    if (n % 10 == 7) {
      has7 = true
      break
    }

    n /= 10
  }

  if (!has7 && !isDiv7) bw.write("0\n")
  else if (!has7 && isDiv7) bw.write("1\n")
  else if (has7 && !isDiv7) bw.write("2\n")
  else bw.write("3\n")

  bw.close()
  br.close()
}