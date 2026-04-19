import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val t = br.readLine().toInt()

    for(i in 1..t){
        val map = HashMap<String,Int>()

        val n = br.readLine().toInt()

        for(j in 1..n){
            val st = StringTokenizer(br.readLine())
            st.nextToken()
            val type = st.nextToken()
            map.put(type, map.getOrDefault(type, 0) + 1)
        }

        val typeArr = ArrayList<String>(map.keys)

        var res = 1
        for(j in 0 until typeArr.size) {
            res *= map.get(typeArr.get(j))!! + 1
        }

        res -= 1

        bw.write("$res\n")
    }

    bw.close()
    br.close()
}