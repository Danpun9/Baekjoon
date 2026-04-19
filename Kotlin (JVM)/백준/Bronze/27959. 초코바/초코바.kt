import java.io.*


fun main(){

    val br = BufferedReader(InputStreamReader(System.`in`))

    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    

    val (n,m) = br.readLine().split(" ").map{it.toInt()}

    

    bw.write(if(n*100 >= m) "Yes" else "No")

    

    bw.close()

    br.close()

}