import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.Comparator
import java.util.PriorityQueue

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val br = BufferedReader(InputStreamReader(System.`in`))

    val t = br.readLine().toInt()

    repeat(t) {
        val k = br.readLine().toInt() // 명령 횟수

        val minPQ = PriorityQueue<Int>() // 최솟값 큐
        val maxPQ = PriorityQueue<Int>(Comparator.reverseOrder()) // 최댓값 큐
        val map = HashMap<Int, Int>() // 이중 큐에 데이터 개수 판단

        for (i in 1..k) {
            val cmd = br.readLine().split(" ")
            val n = cmd[1].toInt()

            when (cmd[0]) {
                // 삽입 연산
                "I" -> {
                    map[n] = map.getOrDefault(n, 0) + 1 // 이중 큐에 삽입된 값 개수

                    // 두 개의 큐에 값 삽입
                    minPQ.add(n)
                    maxPQ.add(n)
                }

                // 제거 연산
                "D" -> {
                    while (map.isNotEmpty()) {
                        val out = if (n == 1) maxPQ.remove() else minPQ.remove()

                        if (map.contains(out)) { // 이중 큐에 값이 있음
                            if (map[out] == 1)
                                map.remove(out)
                            else
                                map[out] = map[out]!! - 1
                            break
                        }
                    }
                }
            }
        }
        if (map.isEmpty()) bw.write("EMPTY\n")
        else {
            val arr = map.keys.toIntArray()
            arr.sort()

            bw.write("${arr[arr.size - 1]} ${arr[0]}\n")
        }
    }

    bw.close()
    br.close()
}