import java.io.*
import java.math.BigInteger

val bw = BufferedWriter(OutputStreamWriter(System.`out`))

fun hanoi(n: Int, from: Int, to: Int, end: Int) {
    if (n == 1) { // 원반이 1개
        bw.write("$from $to\n")
        return
    }

    // 1. n-1개의 원반을 시작에서 보조로 옮김
    hanoi(n - 1, from, end, to)

    // 2. 가장 큰 원반을 시작에서 목표로 옮김
    bw.write("$from $to\n")

    // 3. n-1개의 원반을 보조에서 목표로 옮김
    hanoi(n - 1, end, to, from)
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))


    val n = br.readLine().toInt()

    val k = BigInteger.valueOf(2).pow(n).subtract(BigInteger.ONE)

    bw.write("$k\n")

    if (n <= 20) {
        hanoi(n, 1, 3, 2)
    }

    bw.close()
    br.close()
}