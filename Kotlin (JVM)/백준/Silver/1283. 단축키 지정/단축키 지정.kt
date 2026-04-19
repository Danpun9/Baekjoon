import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine().toInt()

    val res = Array(n) { br.readLine() }
    val menu = res.map { it.lowercase() }.toTypedArray()
    val resIdx = Array(n) { 0 }

    val alphabet = Array(26) { false }

    for (i in 0 until n) {
        val word = menu[i].split(' ').toTypedArray()
        var success = false

        for (j in 0 until word.size) {
            if (!alphabet[word[j][0] - 'a']) {
                alphabet[word[j][0] - 'a'] = true
                for (k in 0 until j) resIdx[i] += word[k].length + 1
                success = true
                break
            }
        }

        if (!success) {
            for (j in 0 until menu[i].length) {
                if (menu[i][j] == ' ') continue
                else if (!alphabet[menu[i][j] - 'a']) {
                    alphabet[menu[i][j] - 'a'] = true
                    resIdx[i] = j
                    success = true
                    break
                }
            }
        }

        if (success) {
            bw.write(res[i].substring(0, resIdx[i]))
            bw.write("[${res[i][resIdx[i]]}]")
            bw.write("${res[i].substring(resIdx[i] + 1, res[i].length)}\n")
        } else bw.write("${res[i]}\n")
    }

    bw.close()
    br.close()
}