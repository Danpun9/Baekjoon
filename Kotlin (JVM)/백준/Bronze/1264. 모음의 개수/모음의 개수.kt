import java.io.*

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  val bw = BufferedWriter(OutputStreamWriter(System.`out`))

  while (true) {
    val str = br.readLine().lowercase()

    if (str == "#") break

    val count =
      str.count { it == 'a' } + str.count { it == 'e' } + str.count { it == 'i' } + str.count { it == 'o' } + str.count { it == 'u' }

    bw.write("$count\n")
  }

  bw.close()
  br.close()
}