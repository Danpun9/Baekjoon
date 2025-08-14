import java.io.*

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  val bw = BufferedWriter(OutputStreamWriter(System.`out`))

  val n = br.readLine().toInt()

  val arr = Array(n) { br.readLine().split(" ") }

  arr.sortWith { o1, o2 ->
    if (o1[1] != o2[1]) return@sortWith o2[1].toInt() - o1[1].toInt()
    else if (o1[2] != o2[2]) return@sortWith o1[2].toInt() - o2[2].toInt()
    else if (o1[3] != o2[3]) return@sortWith o2[3].toInt() - o1[3].toInt()
    else return@sortWith o1[0].compareTo(o2[0])
  }

  arr.forEach { bw.write("${it[0]}\n") }

  bw.close()
  br.close()
}