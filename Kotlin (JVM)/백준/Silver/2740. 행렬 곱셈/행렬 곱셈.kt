import java.io.*

const val div = 1_000_000_007L

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (n, m) = br.readLine().split(' ').map { it.toInt() }

    val A = Array(n) { br.readLine().split(' ').map { it.toInt() } }

    val (mm, k) = br.readLine().split(' ').map { it.toInt() }

    val B = Array(mm) { br.readLine().split(' ').map { it.toInt() } }

    val res = Array(n) { Array(k) { 0 } }

    for (i in 0 until n) {
        for (j in 0 until k) {
            var sum = 0
            
            for (l in 0 until m)
                sum += A[i][l] * B[l][j]

            res[i][j] = sum
        }
    }

    res.forEach {
        it.forEach { a -> bw.write("$a ") }
        bw.write("\n")
    }

    bw.close()
    br.close()
}