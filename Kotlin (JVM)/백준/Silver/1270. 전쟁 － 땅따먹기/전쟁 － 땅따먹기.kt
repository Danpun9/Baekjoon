import java.io.*
import kotlin.math.max

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()

    repeat(n) {
        val cmd = br.readLine().split(' ').toTypedArray()
        val m = HashMap<String, Int>()

        for (i in 1..cmd[0].toInt())
            m[cmd[i]] = m.getOrDefault(cmd[i], 0) + 1

        val res = m.let {
            var res = ""
            var syjkgw = true

            for (i in it) {
                if (i.value.toDouble() > cmd[0].toDouble() / 2.0) {
                    syjkgw = false
                    res = i.key
                }
            }

            if (syjkgw) "SYJKGW"
            else res.toString()
        }

        bw.write(res + "\n")
    }

    bw.close()
    br.close()
}