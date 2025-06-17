import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  val bw = BufferedWriter(OutputStreamWriter(System.`out`))

  var mul = 1
  val arr = br.readLine().mapIndexed { i, x ->
    if (x == '*') {
      mul = if (i % 2 == 0) 1 else 3
      -1
    } else x - '0'
  }

  var sum = 0
  for (i in 0..12) {
    if (arr[i] == -1) continue
    sum += if (i % 2 == 0) arr[i] else arr[i] * 3
  }

  for (i in 0..9) {
    if ((sum + i * mul) % 10 != 0) continue

    bw.write("$i\n")
    break
  }

  bw.close()
  br.close()
}
