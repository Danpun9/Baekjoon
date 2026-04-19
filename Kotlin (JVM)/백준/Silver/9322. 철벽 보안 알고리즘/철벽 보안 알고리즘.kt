import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val t = br.readLine().toInt()

    repeat(t) {
        val n = br.readLine().toInt()
        val key1 = br.readLine().split(" ")
        val key2 = br.readLine().split(" ")
        val word = br.readLine().split(" ")

        val map = HashMap<String, Int>()

        for (i in 0 until n) map.put(key1[i], i)

        var res = Array<String>(n) { "" }
        for (i in 0 until n) res[map[key2[i]]!!] = word[i]

        res.forEach { bw.write("$it ") }
        bw.write("\n")
    }

    bw.close()
    br.close()
}