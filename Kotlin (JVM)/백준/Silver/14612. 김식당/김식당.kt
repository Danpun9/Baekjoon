import java.io.*

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (n, m) = br.readLine().split(' ').map { it.toInt() }

    val post = ArrayList<Table>()

    repeat(n) {
        val cmd = br.readLine().split(' ').toTypedArray()
        when (cmd[0]) {
            "order" -> post.add(Table(cmd[1].toInt(), cmd[2].toInt()))
            "complete" -> {
                for (i in post) {
                    if (i.num != cmd[1].toInt()) continue
                    post.remove(i)
                    break
                }

            }

            "sort" -> post.sort()
        }

        if (post.isEmpty()) bw.write("sleep\n")
        else {
            post.forEach { bw.write("${it.num} ") }
            bw.write("\n")
        }
    }


    bw.close()
    br.close()
}

class Table(val num: Int, val time: Int) : Comparable<Table> {
    override fun compareTo(other: Table): Int {
        return if (this.time == other.time) this.num - other.num
        else this.time - other.time
    }
}
