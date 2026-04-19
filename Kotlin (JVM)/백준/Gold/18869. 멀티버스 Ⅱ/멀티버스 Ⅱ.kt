import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashSet


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val (m, n) = br.readLine().split(' ').map { it.toInt() }

    val universe = Array(m) { Array(n) { 0 } }
    val sortUniv = Array(m) { ArrayList<Int>() }

    for (i in 0 until m) {
        val set = HashSet<Int>()

        val size = br.readLine().split(' ').map { it.toInt() }.toTypedArray()
        for (j in 0 until size.size) {
            universe[i][j] = size[j]
            set.add(size[j])
        }

        sortUniv[i] = ArrayList(set)
        sortUniv[i].sort()
    }


    val compressedUniv = Array(m) { Array(n) { 0 } }
    for (i in 0 until m) {
        for (j in 0 until n) {
            compressedUniv[i][j] = Collections.binarySearch(sortUniv[i], universe[i][j])
        }
    }

    var res = 0
    for (i in 0 until m) {
        for (j in i + 1 until m) {
            if (compressedUniv[i].contentEquals(compressedUniv[j])) res++
        }
    }

    bw.write("$res")

    bw.close()
    br.close()
}
