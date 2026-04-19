import java.io.*

const val div = 1_000_000_007L

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (n, k) = br.readLine().split(' ').map { it.toInt() }

    val numerator = factorial(n)
    val denominator = factorial(k) * factorial(n - k) % div

    val res = numerator * exponentResult(denominator, div - 2L) % div

    bw.write("$res")

    bw.close()
    br.close()
}

fun factorial(n: Int): Long {
    var res = 1L

    for (i in 1..n) {
        res = res * i % div
    }

    return res
}

fun exponentResult(x: Long, exponent: Long): Long {
    if (exponent == 1L) return x % div // x^1

    val halfExpo = exponentResult(x, exponent / 2)

    // x^(a+b) == x^a * x^b
    if (exponent % 2 == 1L) return (halfExpo * halfExpo % div) * x % div
    return halfExpo * halfExpo % div
}