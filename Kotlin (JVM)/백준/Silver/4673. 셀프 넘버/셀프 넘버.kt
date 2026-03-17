import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val check = BooleanArray(10001)
    for (i in 1..10000) {
        val n = d(i)
        if (n < 10001) check[n] = true
    }

    for (i in 1..10000) {
        if (!check[i]) bw.write("$i\n")
    }

    bw.close()
    br.close()
}

fun d(n: Int): Int {
    var sum = n
    var num = n

    while (num != 0) {
        sum += num % 10
        num /= 10
    }

    return sum
}