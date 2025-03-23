import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

lateinit var arr: LongArray
const val div = 1_000_000_007L

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine().toInt()

    arr = br.readLine().split(" ").map { it.toLong() }.toLongArray().sortedArray() // 매운 정도 오름차순 정렬

    var res = 0L
    for (idx1 in 0..<n) {
        for (idx2 in idx1 + 1..<n) {
            if (idx2 - idx1 == 1) { // idx1, idx2 사이에 조합할 음식x
                res += arr[idx2] - arr[idx1] // +고통지수
                res % div
            } else { // idx1, idx2 사이에 조합할 음식o
                res += (arr[idx2] - arr[idx1]) * binExponent((idx2 - idx1 - 1).toLong()) % div // +(고통지수 * (음식 조합 경우의 수))
                res % div
            }
        }
    }

    // 출력
    bw.write("${res % div}")

    bw.close()
    br.close()
}

// 지수 계산
fun binExponent(exponent: Long): Long {
    if (exponent == 1L) return 2L // 2^1

    val halfExpo = binExponent(exponent / 2)

    // 2 ^ exponent -> 2 ^ (halfExpo + halfExpo + 1)
    if (exponent % 2 == 1L) return (halfExpo * halfExpo % div) * 2 % div

    // 2 ^ exponent -> 2 ^ (halfExpo + halfExpo)
    return halfExpo * halfExpo % div
}