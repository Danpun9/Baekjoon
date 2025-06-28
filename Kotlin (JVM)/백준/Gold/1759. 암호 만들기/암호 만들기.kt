import java.io.*

val bw = BufferedWriter(OutputStreamWriter(System.`out`))


lateinit var arr: Array<String>
var L = -1
var C = -1

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))

  val (l, c) = br.readLine().split(" ").map { it.toInt() }
  L = l
  C = c

  arr = br.readLine().split(" ").toTypedArray().sortedArray()

  dfs("", -1)

  bw.close()
  br.close()
}

fun dfs(str: String, idx: Int) {
  if (str.length == L) {
    var aeiou = 0
    str.forEach { if (it == 'a' || it == 'e' || it == 'i' || it == 'o' || it == 'u') aeiou++ }
    if (aeiou >= 1 && aeiou <= str.length - 2) bw.write("$str\n")
    return
  }

  for (i in idx + 1..<C) {
    dfs("$str${arr[i]}", i)
  }
}
