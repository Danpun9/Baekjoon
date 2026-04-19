import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine().toInt()

    val arr = br.readLine().split(" ").map { it.toInt() }.toTypedArray()

    val res = ArrayList<Int>()

    res.add(arr[0])

    for (i in 1 until n) {
        if (res[res.size - 1] < arr[i]) res.add(arr[i])
        else {
            var left = 0
            var right = res.size - 1
            while (left < right) {
                val mid = (right + left) / 2

                if (res[mid] < arr[i]) left = mid + 1
                else right = mid
            }

            res.set(left, arr[i])
        }
    }

    bw.write("${res.size}")

    bw.close()
    br.close()
}