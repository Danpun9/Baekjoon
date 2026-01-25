import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

val bw = BufferedWriter(OutputStreamWriter(System.`out`))

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))


    val root = Node()

    val n = br.readLine().toInt()

    repeat(n) {
        val cmd = br.readLine().split(" ")

        var idx = 1
        var curr = Node(cmd[idx])
        var parent = root

        while (parent.find(curr.word) != null) {
            parent = parent.find(curr.word)!!

            curr = Node(cmd[++idx])
        }

        for (i in idx..cmd[0].toInt()) {
            parent.childList.add(Node(cmd[i]))
            parent = parent.find(cmd[i])!!
        }
    }

    dfs(root, -1)

    bw.close()
    br.close()
}

class Node(val word: String = "root") : Comparable<Node> {
    val childList = PriorityQueue<Node>()

    fun find(str: String): Node? {
        for (i in childList) {
            if (i.word == str) return i
        }

        return null
    }

    override fun compareTo(other: Node): Int {
        return this.word.compareTo(other.word)
    }
}

fun dfs(node: Node, depth: Int) {
    for (i in 0..<depth) bw.write("--")

    if (depth != -1) bw.write(node.word + "\n")

    while (node.childList.isNotEmpty()) {
        dfs(node.childList.remove(), depth + 1)
    }
}