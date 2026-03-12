import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    while (true) {
        val n = br.readLine().toInt()

        if (n == 0) break

        val set = mutableSetOf<Int>()
        var curr = n

        while (!set.contains(curr)) {
            set.add(curr)

            val str = (curr * curr).toString().padStart(8, '0')

            curr = str.substring(2, 6).toInt()
        }

        bw.write("${set.size}\n")
    }


    bw.close()
    br.close()
}