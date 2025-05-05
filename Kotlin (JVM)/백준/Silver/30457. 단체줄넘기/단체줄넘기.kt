import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine().toInt()

    val arr = br.readLine().split(" ").map { it.toInt() }.toIntArray().sorted()

    val set1 = HashSet<Int>()
    val set2 = HashSet<Int>()

    for (i in arr) {
        if (!set1.contains(i)) set1.add(i)
        else if (!set2.contains(i)) set2.add(i)
    }

    bw.write("${set1.size + set2.size}\n")

    bw.close()
    br.close()
}
