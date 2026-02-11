import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    val keyword = HashMap<String, Boolean>()
    repeat(n) {
        keyword[br.readLine()] = true
    }

    var cnt = keyword.size
    repeat(m) {
        val arr = br.readLine().split(",")
        for (word in arr) {

            if (keyword.containsKey(word) && keyword[word]!!) {
                cnt--
                keyword[word] = false
            }
        }
        bw.write("$cnt\n")
    }

    bw.close()
    br.close()
}