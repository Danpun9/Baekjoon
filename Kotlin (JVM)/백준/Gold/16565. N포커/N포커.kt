import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

const val MOD = 10_007

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  val bw = BufferedWriter(OutputStreamWriter(System.`out`))

  val comb = Array(53) { IntArray(53) { if (it == 0) 1 else 0 } }

  for (i in 1..52)
    for (j in 1..52)
      comb[i][j] = (comb[i - 1][j] + comb[i - 1][j - 1]) % MOD

  val n = br.readLine().toInt()
  var res = 0

  for (i in 1..13) {
    if (n - 4 * i < 0) break

    res =
      if (i % 2 == 1) (res + comb[52 - 4 * i][n - 4 * i] * comb[13][i]) % MOD
      else (res - (comb[52 - 4 * i][n - 4 * i] * comb[13][i]) % MOD + MOD) % MOD
  }

  bw.write("$res\n")

  bw.close()
  br.close()
}
