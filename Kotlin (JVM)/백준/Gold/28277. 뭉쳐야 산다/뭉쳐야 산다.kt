import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val (n, q) = br.readLine().split(" ").map { it.toInt() }

    val sets = Array<MutableSet<Int>>(n + 1) { mutableSetOf() }

    for (i in 1..n) {
        val arr = br.readLine().split(" ").map { it.toInt() }.toIntArray()
        for (j in 1..arr[0])
            sets[i].add(arr[j])
    }

    for (i in 1..q) {
        val cmd = br.readLine().split(" ").map { it.toInt() }.toIntArray()

        if (cmd[0] == 1) {
            val (a, b) = cmd.sliceArray(1..2).map { it }

            if (sets[a].size < sets[b].size) {
                val temp = sets[a]
                sets[a] = sets[b]
                sets[b] = temp
            }

            sets[a].addAll(sets[b])
            sets[b].clear()
        } else {
            val a = cmd[1]

            bw.write("${sets[a].size}\n")
        }
    }

    bw.close()
    br.close()
}