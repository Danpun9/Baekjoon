import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine().toInt()

    val hints = Array(n) { br.readLine().split(" ").map { it.toInt() } }
    var res = 0

    for (i in 123..987) {
        val s = i.toString()

        if (s.contains("0")) continue
        if (s[0] == s[1] || s[1] == s[2] || s[2] == s[0]) continue

        var isPossible = true
        for (hint in hints) {
            val StBa = cntStrikeBall(s, hint[0].toString())
            if (StBa.first != hint[1] || StBa.second != hint[2]) {
                isPossible = false
                break
            }
        }

        if (isPossible) res++
    }

    bw.write("$res\n")

    bw.close()
    br.close()
}

fun cntStrikeBall(x: String, guess: String): Pair<Int, Int> {
    var strike = 0
    var ball = 0

    for (i in 0..<3) {
        if (x[i] == guess[i]) {
            strike++
        } else if (x.contains(guess[i])) {
            ball++
        }
    }

    return Pair(strike, ball)
}