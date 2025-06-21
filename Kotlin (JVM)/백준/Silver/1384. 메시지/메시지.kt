import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  val bw = BufferedWriter(OutputStreamWriter(System.`out`))

  var group = 1
  while (true) {
    val n = br.readLine().toInt()
    if (n == 0) break

    bw.write("Group ${group++}\n")

    val nameList = mutableMapOf<Int, String>()
    val badList = ArrayDeque<Pair<Int, Int>>()

    for (i in 0..<n) {
      val cmd = br.readLine().split(" ")
      nameList[i] = cmd[0]

      for (j in 1..<n) {
        if (cmd[j] == "P") continue

        val badName = if (i - j >= 0) i - j else i - j + n

        badList.addLast(Pair(badName, i))
      }
    }

    if (badList.isEmpty()) bw.write("Nobody was nasty\n")
    else {
      while (badList.isNotEmpty()) {
        val (a, b) = badList.removeFirst()
        bw.write("${nameList[a]} was nasty about ${nameList[b]}\n")
      }
    }
    bw.write("\n")
  }

  bw.close()
  br.close()
}
