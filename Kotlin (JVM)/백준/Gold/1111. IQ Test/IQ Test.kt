import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    var n = br.readLine().toInt()
    val arr = br.readLine().split(" ").map { it.toInt() }.toIntArray()

    if (n == 1 || (n == 2 && arr[0] != arr[1])) { // 다음에 올 수 있는 수가 2개 이상
        bw.write("A\n")
        bw.flush()
        return
    }

    // 하나의 숫자가 연속하는 수열
    if (n == 2) {
        bw.write("${arr[0]}\n")
        bw.flush()
        return
    }

    // x(n) = x(n-1) * a + b
    val a = if (arr[0] == arr[1]) 1 else (arr[2] - arr[1]) / (arr[1] - arr[0])
    val b = if (arr[0] == arr[1]) 0 else arr[1] - (arr[0] * a)

    while (n-- > 1) {
        if (arr[n] == arr[n - 1] * a + b) continue

        bw.write("B\n") // 다음 수를 구할 수 없음(이전 수*a+b == 다음 수의 형식이 아님
        bw.flush()
        return
    }

    // 다음 수 출력
    bw.write("${arr[arr.size - 1] * a + b}\n")

    bw.close()
    br.close()
}