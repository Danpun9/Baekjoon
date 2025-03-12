import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    // 수열 A의 크기 N
    val n = br.readLine().toInt()

    // 수열 A
    val arr = br.readLine().split(" ").map { it.toInt() }.toIntArray()

    // 부분 수열
    val res = ArrayList<Int>()

    res.add(arr[0])

    for (i in 1..<n) {
        // arr[i]가 부분 수열의 끝보다 크면 부분 수열의 개수 늘리기
        if (res[res.size - 1] < arr[i]) {
            res.add(arr[i])
            continue
        }

        // 부분 수열의 끝보다 작으면 arr[i]의 부분 수열에서의 위치 탐색
        var l = 0
        var r = res.size - 1

        while (l < r) {
            val mid = (r + l) / 2

            if (res[mid] < arr[i]) l = mid + 1
            else r = mid
        }

        res[l] = arr[i]
    }

    // 부분 수열의 길이
    bw.write("${res.size}")

    bw.close()
    br.close()
}