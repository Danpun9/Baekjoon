import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val br = BufferedReader(InputStreamReader(System.`in`))

    val t = br.readLine().toInt()

    repeat(t) {
        val k = br.readLine().toInt()

        val words = Array(k) { br.readLine() }

        var flag = false
        for (i in 0..<k) {
            for (j in i + 1..<k) {
                if (isPalindrome(words[i] + words[j])) {
                    bw.write(words[i] + words[j] + "\n")
                    flag = true
                    break
                } else if (isPalindrome(words[j] + words[i])) {
                    bw.write(words[j] + words[i] + "\n")
                    flag = true
                    break
                }
            }
            if (flag) break
        }

        if (!flag) bw.write("0\n")
    }


    bw.close()
    br.close()
}

fun isPalindrome(str: String): Boolean {
    val len = str.length - 1

    for (i in 0..len / 2) {
        if (str[i] != str[len - i]) return false
    }

    return true
}