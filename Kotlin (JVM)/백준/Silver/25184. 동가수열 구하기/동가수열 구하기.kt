import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine().toInt()
    val arr = mutableListOf<Int>()

    for (i in 0..<n) {
        var addVal = n / 2 - i

        while (addVal <= n && arr.size < n) {
            arr.add(addVal)
            addVal += n / 2
        }
    }

    if (n == 1) bw.write("1")
    else bw.write(arr.joinToString(" "))

    bw.close()
    br.close()
}