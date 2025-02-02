import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

lateinit var parent: IntArray

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()
    val m = br.readLine().toInt()

    parent = IntArray(n + 1) { it }

    // 연결된 도시는 같은 집합
    for (i in 1..n) {
        val arr = br.readLine().split(" ").map { it.toInt() == 1 }

        for (j in 1..n) {
            if (arr[j - 1]) union(i, j)
        }
    }

    val plan = br.readLine().split(" ").map { it.toInt() }
    val start = findParent(plan[0])
    var res = true

    for (i in 1..<m) {
        val curr = findParent(plan[i])

        // 출발 지점과 계획의 지점이 같은 집합에 있지 않음
        if (start != curr) {
            res = false
            break
        }
    }

    bw.write(if (res) "YES" else "NO")

    bw.close()
    br.close()
}

// 부모 찾기
fun findParent(x: Int): Int {
    if (x == parent[x]) return x

    parent[x] = findParent(parent[x])
    return parent[x]
}

// 집합 연결
fun union(a: Int, b: Int) {
    val ap = findParent(a)
    val bp = findParent(b)

    if (ap != bp) {
        if (ap > bp)
            parent[ap] = bp
        else
            parent[bp] = ap
    }
}