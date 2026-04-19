import  java.io.*
import kotlin.math.abs

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine().toInt()

    val solution = br.readLine().split(" ").map { it.toInt() }.toTypedArray()

    var idx1 = 0
    var idx2 = n - 1

    var res1 = solution[idx1]
    var res2 = solution[idx2]

    var resSolution = abs(solution[idx2] + solution[idx1])

    while (idx2 > idx1) {
        val consistency = solution[idx2] + solution[idx1]
        if (abs(consistency) < resSolution) {
            resSolution = abs(consistency)
            res1 = solution[idx1]
            res2 = solution[idx2]
        }

        if (consistency > 0) idx2--
        else idx1++
    }

    bw.write("$res1 $res2")

    bw.close()
    br.close()
}