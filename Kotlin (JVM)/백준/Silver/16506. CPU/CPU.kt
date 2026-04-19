import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine().toInt()

    for (i in 1..n) {
        val st = StringTokenizer(br.readLine())

        var res: String = ""

        var str = st.nextToken()

        var isC = false
        if (str[str.length - 1] == 'C') {
            isC = true
            str = str.dropLast(1)
        }

        when (str) {
            "ADD" -> res += "0000"
            "SUB" -> res += "0001"
            "MOV" -> res += "0010"
            "AND" -> res += "0011"
            "OR" -> res += "0100"
            "NOT" -> res += "0101"
            "MULT" -> res += "0110"
            "LSFTL" -> res += "0111"
            "LSFTR" -> res += "1000"
            "ASFTR" -> res += "1001"
            "RL" -> res += "1010"
            "RR" -> res += "1011"
        }

        if (isC) res += "10"
        else res += "00"

        for (j in 1..3) {
            val r = st.nextToken().toInt()

            if (j != 3)
                res += Integer.toBinaryString(r).padStart(3, '0')
            else {
                if (isC) res += Integer.toBinaryString(r).padStart(4, '0')
                else {
                    res += Integer.toBinaryString(r).padStart(3, '0')
                    res += "0"
                }
            }
        }

        bw.write("$res\n")
    }

    bw.close()
    br.close()
}