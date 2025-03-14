import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    // 수열 크기 N
    val n = br.readLine().toInt()
    // 수열 A
    val arr = br.readLine().split(" ").map { it.toInt() }.toIntArray()


    val res = ArrayList<Int>() // 부분 수열
    val dp = IntArray(n) // 부분 수열에서 인덱스

    for (i in 0 until n) {
        // arr[i]가 부분 수열의 끝보다 크면 부분 수열의 개수 증가
        if (res.isEmpty() || res[res.size - 1] < arr[i]) {
            res.add(arr[i])
            dp[i] = res.size - 1
            continue
        }

        // arr[i]기 부분 수열의 끝보다 작음
        // arr[i]의 부분 수열에서의 위치 탐색
        var l = 0
        var r = res.size - 1

        while (l < r) {
            val mid = (l + r) / 2

            if (res[mid] < arr[i])
                l = mid + 1
            else
                r = mid
        }

        res[l] = arr[i]
        dp[i] = l
    }

    // 부분 수열의 길이 출력
    bw.write("${res.size}\n")

    // 부분 수열 역추적
    val s = ArrayDeque<Int>()

    var idx = res.size - 1
    for (i in n - 1 downTo 0) {
        if (dp[i] != idx) continue

        idx--
        s.addFirst(arr[i])
    }

    while (s.isNotEmpty())
        bw.write("${s.removeFirst()} ")

    bw.write("\n")

    bw.close()
    br.close()
}