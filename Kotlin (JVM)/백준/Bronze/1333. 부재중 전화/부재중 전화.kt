import java.io.*

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  val bw = BufferedWriter(OutputStreamWriter(System.`out`))

  val (n, l, d) = br.readLine().split(" ").map { it.toInt() }

  var time = 0
  var res = 0

  for (i in 1..n) {
    time += l

    for (t in 1..5) {
      if (res != 0) break
      if ((time % d) == 0) {
        res = time
        break
      }
      time++
    }

    if (i == n && res == 0) {
      while (true) {
        if ((time % d) == 0) {
          res = time
          break
        }
        time++
      }
    }
  }

  bw.write("$res\n")

  bw.close()
  br.close()
}
