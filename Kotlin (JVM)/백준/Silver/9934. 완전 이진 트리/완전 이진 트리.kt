import java.io.*

lateinit var arr: List<Int>
lateinit var tree: Array<ArrayList<Int>>
var k = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    k = br.readLine().toInt()

    arr = br.readLine().split(" ").map { it.toInt() }
    tree = Array(k) { ArrayList<Int>() }

    dfs(0, arr.size - 1, 0)

    for (i in 0 until k) {
        for (j in tree[i]) {
            bw.write("$j ")
        }
        bw.write("\n")
    }

    bw.close()
    br.close()
}

fun dfs(l: Int, r: Int, depth: Int) {
    if (depth == k) return

    val mid = (l + r) / 2
    tree[depth].add(arr[mid])

    dfs(l, mid - 1, depth + 1)
    dfs(mid + 1, r, depth + 1)
}