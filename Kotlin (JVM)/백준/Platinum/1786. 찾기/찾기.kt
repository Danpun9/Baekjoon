import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

val res = ArrayList<Int>()
lateinit var pi: IntArray

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val T = br.readLine() // 문장 (긴 문자열)
    val P = br.readLine() // 찾을 단어 (패턴)

    pi = IntArray(P.length) // pi 배열

    kmp(T, P)

    bw.write("${res.size}\n")

    res.forEach { bw.write("${it + 1} ") }

    bw.close()
    br.close()
}

// pi 배열 : 0~i 까지의 부분 문자열 중에서 접두사와 접미사가 같은 경우, 접두사의 길이를 저장
fun getPi(pattern: String) {
    var j = 0
    for (i in 1..<pattern.length) {
        while (j > 0 && pattern[i] != pattern[j]) j = pi[j - 1]
        if (pattern[i] == pattern[j]) pi[i] = ++j // 접두사와 접미사가 같음
    }
}

fun kmp(str: String, pattern: String) {
    getPi(pattern)

    val n = str.length
    val m = pattern.length
    var j = 0

    for (i in 0..<n) {
        while (j > 0 && str[i] != pattern[j]) j = pi[j - 1]

        if (str[i] == pattern[j]) { // 문자열의 글자가 패턴의 글자와 일치
            if (j == m - 1) { // j가 패턴의 끝 글자를 가리킴
                res.add(i - m + 1) // 결과 증가
                j = pi[j] // 패턴의 접두사 만큼 이동
            } else ++j // 패턴의 다음 글자로 이동
        }
    }
}