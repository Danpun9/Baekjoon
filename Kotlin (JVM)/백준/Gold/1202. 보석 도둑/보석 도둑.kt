import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val (n, k) = br.readLine().split(" ").map { it.toInt() }

    val jewels = PriorityQueue<Jewel>()
    val bag = Array<Int>(k) { 0 }

    repeat(n) {
        val (weight, price) = br.readLine().split(" ").map { it.toInt() }
        jewels.add(Jewel(weight, price))
    }

    repeat(k) {
        bag[it] = br.readLine().toInt()
    }

    bag.sort()

    val pq = PriorityQueue<Int>(Collections.reverseOrder())
    var res = 0L

    for (i in bag) {
        while (jewels.isNotEmpty()) {
            if (jewels.peek().weight <= i) pq.add(jewels.remove().price)
            else break
        }

        if (pq.isNotEmpty()) res += pq.remove()
    }

    bw.write("$res")

    bw.close()
    br.close()
}

class Jewel(val weight: Int, val price: Int) : Comparable<Jewel> {
    override operator fun compareTo(other: Jewel): Int {
        if (this.weight == other.weight) return other.price - this.price
        return this.weight - other.weight
    }
}