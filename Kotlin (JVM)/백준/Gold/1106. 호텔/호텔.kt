import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (c, n) = br.readLine()!!.split(" ").map { it.toInt() }
    
    val cities = mutableListOf<Pair<Int, Int>>()
    repeat(n) {
        val (cost, customers) = br.readLine()!!.split(" ").map { it.toInt() }
        cities.add(cost to customers)
    }

    val maxCustomers = c + 100
    val dp = IntArray(maxCustomers + 1) { Int.MAX_VALUE }
    dp[0] = 0
    
    for (i in 1..maxCustomers) {
        for ((cost, customers) in cities) {
            if (i >= customers && dp[i - customers] != Int.MAX_VALUE) {
                dp[i] = minOf(dp[i], dp[i - customers] + cost)
            }
        }
    }

    var minCost = Int.MAX_VALUE
    for (i in c..maxCustomers) {
        if (dp[i] != Int.MAX_VALUE) {
            minCost = minOf(minCost, dp[i])
        }
    }
    
    bw.write("$minCost\n")

    bw.close()
    br.close()
}