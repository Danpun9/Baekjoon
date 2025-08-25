import java.io.*

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  val bw = BufferedWriter(OutputStreamWriter(System.`out`))

  val n = br.readLine().toInt()

  var globalMax = 0
  var res = 0

  for (r in 1..n) {

    val arr = br.readLine().split(" ").map { it.toInt() }.toIntArray()

    var max = -1

    for (j in 0 until 5)
      for (i in 0..<5)
        for (j in i + 1..<5)
          for (k in j + 1..<5)
            max = maxOf(max, (arr[i] + arr[j] + arr[k]) % 10)

    if (max >= globalMax) {
      res = r
      globalMax = max
    }
  }

  bw.write("$res\n")

  bw.close()
  br.close()
}