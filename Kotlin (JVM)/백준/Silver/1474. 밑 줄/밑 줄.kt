import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val words = Array(n) { br.readLine() }

    val totalWordLen = words.sumOf { it.length } // 현재 단어 총 길이
    val underbarCnt = m - totalWordLen // 필요 _ 개수

    val baseUnder = underbarCnt / (n - 1) // 기본 _ 개수
    var extraUnder = underbarCnt % (n - 1) // 추가 _ 개수

    val isExtra = BooleanArray(n - 1) // i번째 단어 사이에 _ 개수 추가 여부

    // 소문자 우선 추가
    for (i in 1..<n) {
        if (words[i][0].isLowerCase() && extraUnder > 0) {
            isExtra[i - 1] = true
            extraUnder--
        }
    }

    // 오른쪽에서 왼쪽으로 추가
    for (i in n - 1 downTo 1) {
        if (!isExtra[i - 1] && extraUnder > 0) {
            isExtra[i - 1] = true
            extraUnder--
        }
    }

    // 출력
    bw.write(words[0])
    for (i in 1..<n) {
        for (j in 1..baseUnder + if (isExtra[i - 1]) 1 else 0)
            bw.write("_")
        bw.write(words[i])
    }

    bw.close()
    br.close()
}


// 대문자 < _ < 소문자 순서