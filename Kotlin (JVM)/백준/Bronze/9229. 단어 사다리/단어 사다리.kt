import java.io.*

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  val bw = BufferedWriter(OutputStreamWriter(System.`out`))

  while (true) {
    var str = br.readLine()
    var res = true

    if (str == "#") break

    while (true) {
      val compareStr = br.readLine()
      if (compareStr == "#") break

      if (!res) continue

      if (str.length != compareStr.length) res = false
      var change = false

      for (i in 0..<str.length) {
        if (str[i] == compareStr[i]) continue
        else if (!change) change = true
        else {
          res = false
          break
        }
      }

      if (!change) res = false

      str = compareStr
    }

    bw.write(if (res) "Correct\n" else "Incorrect\n")
  }

  bw.close()
  br.close()
}