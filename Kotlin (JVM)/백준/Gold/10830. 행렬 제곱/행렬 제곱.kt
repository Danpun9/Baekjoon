import java.io.*

lateinit var A: Array<Array<Int>>

const val div = 1000

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val br = BufferedReader(InputStreamReader(System.`in`))

    var (n, b) = br.readLine().split(' ').map { it.toLong() }

    A = Array(n.toInt()) { br.readLine().split(' ').map { it.toInt() % div }.toTypedArray() }

    val res = pow(A, b)

    res.forEach { arr ->
        arr.forEach {
            bw.write("$it ")
        }
        bw.write("\n")
    }

    bw.close()
    br.close()
}

fun pow(matrix: Array<Array<Int>>, expo: Long): Array<Array<Int>> {
    if (expo == 1L) return matrix

    var res = pow(matrix, expo / 2)

    res = matrix_multiple(res, res)

    if (expo % 2 == 1.toLong()) res = matrix_multiple(res, A)

    return res
}

fun matrix_multiple(matrix1: Array<Array<Int>>, matrix2: Array<Array<Int>>): Array<Array<Int>> {
    val n = A.size
    val res = Array(n) { Array(n) { 0 } }

    for (i in 0 until n) {
        for (j in 0 until n) {
            for (k in 0 until n) {
                res[i][j] += matrix1[i][k] * matrix2[k][j]
                res[i][j] %= div
            }
        }
    }

    return res
}