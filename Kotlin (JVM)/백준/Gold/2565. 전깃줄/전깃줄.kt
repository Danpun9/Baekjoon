import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine().toInt()

    val arr = ArrayList<Line>()
    repeat(n) {
        val (a, b) = br.readLine().split(' ').map { it.toInt() }
        arr.add(Line(a, b))
    }

    arr.sort()

    val res = ArrayList<Int>()

    res.add(arr[0].a)

    for (i in 1 until n) {
        if (res[res.size - 1] < arr[i].a) res.add(arr[i].a)
        else {
            var left = 0
            var right = res.size - 1
            while (left < right) {
                val mid = (left + right) / 2
                if (res[mid] < arr[i].a) left = mid + 1
                else right = mid
            }

            res[left] = arr[i].a
        }
    }

    bw.write("${n - res.size}")

    bw.close()
    br.close()
}

class Line(val a: Int, val b: Int) : Comparable<Line> {
    override fun compareTo(other: Line): Int {
        return this.b - other.b
    }
}