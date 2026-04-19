import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val p = br.readLine().toInt()

    repeat(p) {
        val arr = br.readLine().split(" ").map { it.toInt() }.toTypedArray()

        val s = ArrayDeque<Int>()

        s.addFirst(arr[1])

        var res = 0
        for (i in 2..12) {
            if (s[0] < arr[i]) {
                res++
                s.addFirst(arr[i])
            } else if (s[0] == arr[i]) s.addFirst(arr[i])
            else if (s[0] > arr[i]) {
                while (s.isNotEmpty()) {
                    if (s[0] <= arr[i]) break
                    s.removeFirst()
                }

                if (s[0] < arr[i]) {
                    res++
                    s.addFirst(arr[i])
                }
            }
        }

        bw.write("${arr[0]} $res\n")
    }

    bw.close()
    br.close()
}