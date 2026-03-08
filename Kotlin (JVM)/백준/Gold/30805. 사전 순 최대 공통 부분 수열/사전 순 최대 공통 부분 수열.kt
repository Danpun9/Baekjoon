import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine().trim().toInt()
    val A = br.readLine().trim().split(" ").map { it.toInt() }.toIntArray()
    val m = br.readLine().trim().toInt()
    val B = br.readLine().trim().split(" ").map { it.toInt() }.toIntArray()

    var aIdx = 0
    var bIdx = 0

    val res = mutableListOf<Int>()

    while (aIdx < n && bIdx < m) {
        val partA = A.sliceArray(aIdx..<A.size)
        val partB = B.sliceArray(bIdx..<B.size)

        val commonMax = partA.intersect(partB.toList()).maxOrNull() ?: break

        res.add(commonMax)
        aIdx += partA.indexOf(commonMax) + 1
        bIdx += partB.indexOf(commonMax) + 1
    }

    bw.write("${res.size}\n")
    bw.write("${res.joinToString(" ")}\n")
    
    bw.close()
    br.close()
}