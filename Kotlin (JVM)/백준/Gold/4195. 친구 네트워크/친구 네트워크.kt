import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

lateinit var parent: IntArray
lateinit var size: IntArray

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val br = BufferedReader(InputStreamReader(System.`in`))

    val t = br.readLine().toInt()

    repeat(t) {
        val n = br.readLine().toInt()

        val map = HashMap<String, Int>() 
        var idx = 0
        parent = IntArray(200001) { it }
        size = IntArray(200001) { 1 }

        repeat(n) {
            val (a, b) = br.readLine().split(" ")

            if (map[a] == null) map[a] = idx++
            if (map[b] == null) map[b] = idx++

            val ap = findParent(map[a]!!)
            val bp = findParent(map[b]!!)

            bw.write("${union(ap, bp)}\n")
        }
    }

    bw.close()
    br.close()
}

fun findParent(x: Int): Int {
    if (parent[x] == x) return parent[x]

    parent[x] = findParent(parent[x])

    return parent[x]
}

fun union(x: Int, y: Int): Int {
    val xx = findParent(x)
    val yy = findParent(y)

    if (xx == yy) return size[xx]

    if (xx > yy) {
        parent[xx] = yy
        size[yy] += size[xx]
        return size[yy]
    } else {
        parent[yy] = xx
        size[xx] += size[yy]
        return size[xx]
    }
}