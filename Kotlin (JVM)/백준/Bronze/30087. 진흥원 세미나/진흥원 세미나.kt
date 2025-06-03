import java.io.*

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  val bw = BufferedWriter(OutputStreamWriter(System.`out`))

  val map =
    mapOf(
      Pair("Algorithm", "204"),
      Pair("DataAnalysis", "207"),
      Pair("ArtificialIntelligence", "302"),
      Pair("CyberSecurity", "B101"),
      Pair("Network", "303"),
      Pair("Startup", "501"),
      Pair("TestStrategy", "105")
    )

  var n = br.readLine().toInt()

  while (n-- > 0) bw.write("${map[br.readLine()]}\n")

  bw.close()
  br.close()
}