import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val prime = BooleanArray(1001) { true }
    prime[0] = false
    prime[1] = false

    for (i in 2..1000) {
        if (!prime[i]) continue
        for (j in i * i..1000 step i)
            prime[j] = false
    }

    val (a, b) = br.readLine().trim().split(" ").map { it.toInt() }
    val (c, d) = br.readLine().trim().split(" ").map { it.toInt() }

    val yt = (a..b).filter { prime[it] }.toSet()
    val yj = (c..d).filter { prime[it] }.toSet()

    val commonPrime = yt.intersect(yj).size
    val ytPrime = yt.size - commonPrime + if (commonPrime % 2 == 1) 1 else 0
    val yjPrime = yj.size - commonPrime

    bw.write(if (ytPrime > yjPrime) "yt\n" else "yj\n")

    bw.close()
    br.close()
}