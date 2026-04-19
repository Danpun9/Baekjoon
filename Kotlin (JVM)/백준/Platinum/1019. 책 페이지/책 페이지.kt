import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

val number = LongArray(10)
var start = 1
var digit = 1

var N = 0

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val br = BufferedReader(InputStreamReader(System.`in`))

    N = br.readLine().toInt()

    while (start <= N) {
        while (start % 10 != 0 && start <= N) {
            count(start)
            start++
        }

        while (N % 10 != 9 && start <= N) {
            count(N)
            N--
        }

        if (start > N) break

        start /= 10
        N /= 10

        for (i in 0..9) number[i] += ((N - start + 1) * digit).toLong()

        digit *= 10
    }

    for (num in number) {
        bw.write("$num ")
    }

    bw.close()
    br.close()
}

fun count(x: Int) {
    var num = x
    while (num > 0) {
        number[num % 10] += digit.toLong()
        num /= 10
    }
}