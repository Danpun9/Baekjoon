import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine().toInt()

    val prime = BooleanArray(n + 1)
    prime[0] = true
    prime[1] = true

    for (i in 2..n) {
        if (i * i > n) break

        if (!prime[i]) for (j in i * i..n step (i)) prime[j] = true
    }

    val primeList = ArrayList<Int>()

    for (i in 0..n) {
        if (!prime[i]) primeList.add(i)
    }

    var l = 0
    var r = 0
    var sum = 0
    var cnt = 0

    while (true) {
        if (sum >= n) sum -= primeList[l++]
        else if (r == primeList.size) break
        else sum += primeList[r++]

        if (n == sum) cnt++
    }

    bw.write("$cnt")

    bw.close()
    br.close()
}