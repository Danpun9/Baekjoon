import java.io.*

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  val bw = BufferedWriter(OutputStreamWriter(System.`out`))

  val jump = br.readLine().map { it == 'o' }.toBooleanArray()
  val stand = br.readLine().map { it == 'o' }.toBooleanArray()
  br.readLine()
  br.readLine()
  br.readLine()

  val res = IntArray(jump.size) { idx ->
    if (jump[idx]) 0
    else if (stand[idx]) 1
    else -1
  }

  for (i in res.indices) {
    bw.write(
      when (res[i]) {
        1 -> "o"
        else -> "."
      }
    )
  }
  bw.write("\n")

  for (i in res.indices) {
    bw.write(
      when (res[i]) {
        1 -> "w"
        0 -> "o"
        else -> "."
      }
    )
  }
  bw.write("\n")

  for (i in res.indices) {
    bw.write(
      when (res[i]) {
        1 -> "l"
        0 -> "m"
        else -> "o"
      }
    )
  }
  bw.write("\n")

  for (i in res.indices) {
    bw.write(
      when (res[i]) {
        1 -> "n"
        0 -> "l"
        else -> "L"
      }
    )
  }
  bw.write("\n")

  for (i in res.indices) {
    bw.write(
      when (res[i]) {
        1 -> "."
        0 -> "n"
        else -> "n"
      }
    )
  }
  bw.write("\n")

  bw.close()
  br.close()
}