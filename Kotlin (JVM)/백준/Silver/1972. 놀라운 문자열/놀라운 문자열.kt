import java.io.*

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val br = BufferedReader(InputStreamReader(System.`in`))

    while (true) {
        val str = br.readLine()

        if (str == "*") break

        var surprise = true

        for (i in 1 until str.length) {
            val set = HashSet<String>()

            for (j in 0 until str.length - i) {
                val sub = str[j].toString() + str[j + i].toString()
                if (!set.contains(sub)) set.add(sub)
                else {
                    surprise = false
                    break
                }
            }

            if (!surprise) break
        }

        if (surprise) bw.write("$str is surprising.\n")
        else bw.write("$str is NOT surprising.\n")
    }

    bw.close()
    br.close()
}