import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

lateinit var inorderList: IntArray // 중위 순회 (좌측->루트->우측)
lateinit var postorderList: IntArray // 후위 순회(좌측->우측->루트)
lateinit var inorderIndex: IntArray // 중위 순회에서 노드의 인덱스

val preOrder = ArrayList<Int>() // 전위 순회 (루트->좌측->우측)

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val br = BufferedReader(InputStreamReader(System.`in`))

    // 입력 및 변수 설정
    val n = br.readLine().toInt()

    inorderIndex = IntArray(n + 1)
    var idx = 0
    inorderList = br.readLine().split(" ").map {
        inorderIndex[it.toInt()] = idx++
        it.toInt()
    }.toIntArray()
    postorderList = br.readLine().split(" ").map { it.toInt() }.toIntArray()


    // 탐색
    dfs(0, n - 1, 0, n - 1)

    // 출력
    preOrder.forEach { bw.write("$it ") }

    bw.close()
    br.close()
}

// 탐색
fun dfs(inStart: Int, inEnd: Int, postStart: Int, postEnd: Int) {
    if (inStart > inEnd || postStart > postEnd) return // 범위 넘어가면 탐색x

    preOrder.add(postorderList[postEnd]) // 후위 순회의 가장 오른쪽은 루트 노드

    // 중위 순회에서 루트의 인덱스 찾기
    val inMid = inorderIndex[preOrder[preOrder.size - 1]]

    // 중위 순회의 범위와 후위 순회의 범위를 수정 후 탐색
    dfs(inStart, inMid - 1, postStart, postStart + (inMid - inStart - 1))
    dfs(inMid + 1, inEnd, postStart + (inMid - inStart), postEnd - 1)
}
