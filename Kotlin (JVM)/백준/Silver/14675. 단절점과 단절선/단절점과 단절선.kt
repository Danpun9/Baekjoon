import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine().toInt()

    val tree = Array(n + 1) { mutableListOf<Int>() }
    repeat(n - 1) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        tree[a].add(b)
        tree[b].add(a)
    }

    val q = br.readLine().toInt()

    repeat(q) {
        val (t, k) = br.readLine().split(" ").map { it.toInt() }

        if (t == 1) {
            if (tree[k].size >= 2) bw.write("yes\n")
            else bw.write("no\n")
        } else {
            bw.write("yes\n")
        }
    }

    bw.close()
    br.close()
}