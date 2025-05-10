import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine().toInt()

    val p = br.readLine()
    val q = br.readLine()
    val r = br.readLine()

    val eq = p.equals(q) || q.equals(r) || r.equals(p)

    var hIj = -1
    var hIs = -1
    var jIs = -1

    for (i in 0..<n) {
        if (r[i] != q[i]) {
            if (r[i] == 'H' && q[i] == 'J') hIj = 1
            else if (r[i] == 'H' && q[i] == 'S') hIs = 1
            else if (r[i] == 'J' && q[i] == 'S') jIs = 1
            else if (r[i] == 'J' && q[i] == 'H') hIj = 0
            else if (r[i] == 'S' && q[i] == 'H') hIs = 0
            else if (r[i] == 'S' && q[i] == 'J') jIs = 0

            break
        }
    }

    var flag = false
    for (i in 0..<n) {
        if (q[i] != p[i]) {
            if (q[i] == 'H' && p[i] == 'J' && (hIj == 1 || hIj == -1)) flag = true
            else if (q[i] == 'H' && p[i] == 'S' && (hIs == 1 || hIs == -1)) flag = true
            else if (q[i] == 'J' && p[i] == 'S' && (jIs == 1 || jIs == -1)) flag = true
            else if (q[i] == 'J' && p[i] == 'H' && (hIj == 0 || hIj == -1)) flag = true
            else if (q[i] == 'S' && p[i] == 'H' && (hIs == 0 || hIs == -1)) flag = true
            else if (q[i] == 'S' && p[i] == 'J' && (jIs == 0 || jIs == -1)) flag = true

            break
        }
    }

    bw.write(if (!eq && flag) "HJS! HJS! HJS!\n" else "Hmm...\n")

    bw.close()
    br.close()
}
