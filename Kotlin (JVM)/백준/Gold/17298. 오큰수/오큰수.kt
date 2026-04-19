import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine().toInt()

    val arr = br.readLine().split(' ').map { it.toInt() }.toTypedArray()

    val s = ArrayDeque<Int>()

    for (i in 0 until n) {
        while (s.isNotEmpty() && arr[s.first()] < arr[i])
            arr[s.removeFirst()] = arr[i]

        s.addFirst(i)
    }

    while (s.isNotEmpty())
        arr[s.removeFirst()] = -1
    
    arr.forEach { bw.write("$it ") }
    
    bw.close()
    br.close()
}