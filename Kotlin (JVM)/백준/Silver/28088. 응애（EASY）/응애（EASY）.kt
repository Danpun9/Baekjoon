import java.io.*

lateinit var arr: IntArray
lateinit var isEungAe: BooleanArray

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val (n, m, k) = br.readLine().split(" ").map { it.toInt() }

    isEungAe = BooleanArray(n)

    repeat(m) {
        val i = br.readLine().toInt()

        isEungAe[i] = true
    }

    repeat(k) {
        arr = IntArray(n) { 0 }

        for (i in 0..<n) if (isEungAe[i]) hello(i)
        for (i in 0..<n)
            if (arr[i] == 0 || arr[i] == 2) isEungAe[i] = false
            else if (arr[i] == 1) isEungAe[i] = true

    }

    var res = 0
    isEungAe.forEach { if (it) res++ }

    bw.write("$res\n")

    bw.close()
    br.close()
}

fun hello(x: Int) {
    if (x == 0) {
        arr[x + 1]++
        arr[arr.size - 1]++
        return
    }

    if (x == arr.size - 1) {
        arr[0]++
        arr[x - 1]++
        return
    }

    arr[x + 1]++
    arr[x - 1]++
}