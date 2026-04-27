import java.io.*

class Food(val t: Int, val a: Long, val b: Long)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (n, d) = br.readLine().split(" ").map { it.toInt() }

    val foods = Array(n) {
        val (t, a, b) = br.readLine().split(" ").map { it.toLong() }
        Food(t.toInt(), a, b)
    }.sortedBy { it.t }

    var res = 0L

    // 요리 1개 선택
    for (i in 0 until n)
        res = maxOf(res, foods[i].a + foods[i].b)

    // 요리 2개 선택
    val max1 = LongArray(n) // 첫 번째로 큰 b점수 배열
    val max2 = LongArray(n) // 두 번째로 큰 b점수 배열
    val maxIdx = IntArray(n) // 첫 번째로 큰 b점수의 인덱스 배열
    
    max1[0] = foods[0].b
    max2[0] = -1L
    maxIdx[0] = 0
    
    for (i in 1 until n) {
        if (foods[i].b > max1[i - 1]) {
            max1[i] = foods[i].b
            max2[i] = max1[i - 1]
            maxIdx[i] = i
        } else {
            max1[i] = max1[i - 1]
            max2[i] = maxOf(max2[i - 1], foods[i].b)
            maxIdx[i] = maxIdx[i - 1]
        }
    }
    
    // 각 요리의 a점수를 기본, b점수가 가장 높은 요리 탐색
    for (i in 0 until n) {
        val time = d - foods[i].t

        var l = 0
        var r = n - 1
        var max = -1
        while (l <= r) {
            val mid = (l + r) / 2
            if (foods[mid].t <= time) {
                max = mid
                l = mid + 1
            } else {
                r = mid - 1
            }
        }

        if (max >= 0) {
            val maxB = if (maxIdx[max] == i) max2[max] else max1[max]

            if (maxB != -1L) {
                res = maxOf(res, foods[i].a + maxB)
            }
        }

    }

    bw.write("$res\n")

    bw.close()
    br.close()
}
