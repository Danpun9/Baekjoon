import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    while (true) {
        val str = br.readLine() ?: break

        val (n, m) = str.split(' ').map { it.toInt() }

        var res = 0
        for (i in n..m) {
            var num = i

            val isContained = Array(10) { false }
            var success = true

            while (num > 0) {
                if (isContained[num % 10]) {
                    success = false
                    break
                }

                isContained[num % 10] = true
                num /= 10
            }
            if (success) res++
        }

        bw.write("$res\n")
    }


    bw.close()
    br.close()
}