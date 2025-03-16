import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine().toInt()

    val arr = Array(n) {
        val (x, y) = br.readLine().split(" ").map { it.toInt() }
        Line(x, y)
    }

    arr.sort()

    var min = arr[0].start
    var max = arr[0].end
    var len = max - min

    for (i in 1..<n) {
        len += if (min <= arr[i].start && arr[i].end <= max) continue // 선이 완전히 겹침
        else if (arr[i].start < max) arr[i].end - max // 선이 일부분 겹침
        else arr[i].end - arr[i].start // 선이 겹치지 않음

        min = arr[i].start
        max = arr[i].end
    }

    bw.write("$len")

    bw.close()
    br.close()
}

data class Line(val start: Int, val end: Int) : Comparable<Line> {
    override fun compareTo(other: Line): Int {
        return if (this.start != other.start) this.start - other.start
        else this.end - other.end
    }
}