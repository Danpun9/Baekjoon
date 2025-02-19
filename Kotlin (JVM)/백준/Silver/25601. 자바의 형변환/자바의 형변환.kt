import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

val parent = ArrayList<Int>()
val map = HashMap<String, Int>()

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()

    var idx = 0
    repeat(n - 1) {
        val (obj1, obj2) = br.readLine().split(" ")
        if (map[obj1] == null) {
            map[obj1] = idx
            parent.add(idx++)
        }
        if (map[obj2] == null) {
            map[obj2] = idx
            parent.add(idx++)
        }

        parent[map[obj1]!!] = map[obj2]!!
    }

    val (val1, val2) = br.readLine().split(" ")
    if (findParent(val1, val2) || findParent(val2, val1)) bw.write("1")
    else bw.write("0")

    bw.close()
    br.close()
}

fun findParent(o1: String, o2: String): Boolean {
    var curr = map[o1]!!
    val findIdx = map[o2]!!

    while (parent[curr] != findIdx && parent[curr] != curr)
        curr = parent[curr]

    return parent[curr] == findIdx
}