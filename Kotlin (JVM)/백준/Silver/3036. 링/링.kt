import java.io.*

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  val bw = BufferedWriter(OutputStreamWriter(System.`out`))

  br.readLine()

  val arr = br.readLine().split(" ").map { it.toInt() }.toIntArray()

  for (i in 1..<arr.size) {
    val gcd = gcd(arr[0], arr[i])

    bw.write("${arr[0] / gcd}/${arr[i] / gcd}\n")
  }

  bw.close()
  br.close()
}

fun gcd(a: Int, b: Int): Int {

  var aa = a
  var bb = b

  while (bb != 0) {
    val r = aa % bb
    aa = bb
    bb = r
  }

  return aa
}