import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val (n, m) = br.readLine().split(' ').map { it.toInt() }

    val upper = HashMap<String, String>()
    val under = HashMap<String, ArrayList<String>>()

    repeat(n) {
        val group = br.readLine()
        val num = br.readLine().toInt()
        val member = ArrayList<String>()
        repeat(num) {
            val name = br.readLine()
            member.add(name)
            upper[name] = group
        }
        member.sort()
        under[group] = member
    }

    repeat(m) {
        val q = br.readLine()
        val type = br.readLine() == "1"

        if (type)
            bw.write("${upper[q]}\n")
        else
            under[q]!!.forEach { bw.write("$it\n") }
    }

    bw.close()
    br.close()
}