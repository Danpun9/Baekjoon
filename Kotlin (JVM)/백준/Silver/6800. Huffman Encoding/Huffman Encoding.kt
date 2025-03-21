import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val k = br.readLine().toInt()

    val root = Node(null)

    repeat(k) {
        val (character, bin) = br.readLine().split(" ")

        var curr = root

        for (i in bin) {
            if (i == '0') {
                if (curr.leftChild == null) curr.leftChild = Node(null)
                curr = curr.leftChild!!
            } else {
                if (curr.rightChild == null) curr.rightChild = Node(null)
                curr = curr.rightChild!!
            }
        }

        curr.character = character.toCharArray()[0]
    }

    val str = br.readLine().map { it - '0' }.toIntArray()

    var curr = root
    for (i in str) {
        curr = if (i == 0) curr.leftChild!!
        else curr.rightChild!!

        if (curr.character != null) {
            bw.write("${curr.character}")
            curr = root
        }
    }

    bw.close()
    br.close()
}

data class Node(var character: Char?) {
    var leftChild: Node? = null
    var rightChild: Node? = null
}