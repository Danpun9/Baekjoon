import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.max
import kotlin.math.min

lateinit var histogram: Array<Long>

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    while (true) {
        val n = br.readLine().split(' ').map { it.toLong() }.toTypedArray()

        if (n[0] == 0L) break

        histogram = n.sliceArray(1..<n.size)

        bw.write("${subArea(0, n[0].toInt() - 1)}\n")
    }

    bw.close()
    br.close()
}

fun subArea(leftIdx: Int, rightIdx: Int): Long {
    if (leftIdx == rightIdx) return histogram[leftIdx]

    val midIdx = (rightIdx + leftIdx) / 2

    val leftMaxArea = subArea(leftIdx, midIdx)
    val rightMaxArea = subArea(midIdx + 1, rightIdx)

    var maxArea = max(leftMaxArea, rightMaxArea)

    maxArea = max(maxArea, midArea(leftIdx, rightIdx, midIdx))

    return maxArea
}

fun midArea(left: Int, right: Int, mid: Int): Long {
    var leftIdx = mid
    var rightIdx = mid

    var minHeight = histogram[mid]

    var maxArea = minHeight

    while (left < leftIdx && right > rightIdx) {

        if (histogram[leftIdx - 1] < histogram[rightIdx + 1]) {
            rightIdx++
            minHeight = min(minHeight, histogram[rightIdx])
        } else {
            leftIdx--
            minHeight = min(minHeight, histogram[leftIdx])
        }

        maxArea = max(maxArea, minHeight * (rightIdx - leftIdx + 1))
    }

    while (rightIdx < right) {
        rightIdx++
        minHeight = min(minHeight, histogram[rightIdx])
        maxArea = max(maxArea, minHeight * (rightIdx - leftIdx + 1))
    }

    while (leftIdx > left) {
        leftIdx--
        minHeight = min(minHeight, histogram[leftIdx])
        maxArea = max(maxArea, minHeight * (rightIdx - leftIdx + 1))
    }

    return maxArea
}