import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val t = br.readLine().toInt()

    repeat(t) {
        val n = br.readLine().toInt()

        val address = Array(n) { br.readLine() }
        address.sort()

        bw.write("${if (check(address)) "YES" else "NO"}\n")
    }

    bw.close()
    br.close()
}

fun check(address: Array<String>): Boolean {
    for (i in 1..<address.size)
        if (address[i].startsWith(address[i - 1]))
            return false

    return true
}