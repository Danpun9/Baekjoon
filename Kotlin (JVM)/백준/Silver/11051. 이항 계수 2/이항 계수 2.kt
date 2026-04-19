import java.io.*

lateinit var memo: Array<Array<Int?>>
val div = 10_007

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (n, k) = br.readLine().split(' ').map { it.toInt() }

    memo = Array(n + 1) { Array(k + 1) { null } }

    bw.write(binomialCoefficient(n, k).toString())

    bw.close()
    br.close()
}

fun binomialCoefficient(n: Int, k: Int): Int {
    if (memo[n][k] != null) return memo[n][k]!!

    if (n == k || k == 0) {// nC0 == 1, nCn == 1
        memo[n][k] = 1
        return 1
    }

    memo[n][k] = (binomialCoefficient(n - 1, k - 1) + binomialCoefficient(n - 1, k)) % div // nCk == n-1Ck-1 + n-1Ck
    return memo[n][k]!!
}
