import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val (case, str) = br.readLine().split(' ')

    bw.write("${camelCase(case, str)}\n${snake_case(case, str)}\n${PascalCase(case, str)}\n")

    bw.close()
    br.close()
}

fun camelCase(case: String, str: String): String {

    var res = ""

    when (case) {
        "1" -> res = str
        "2" -> {
            var up = false
            for (i in str) {
                if (up) {
                    res += i.uppercase()
                    up = false
                } else if (i == '_') up = true
                else res += i
            }
        }

        else -> {
            res = str[0].lowercase() + str.substring(1)
        }
    }

    return res
}

fun snake_case(case: String, str: String): String {
    var res = ""

    when (case) {
        "1" -> {
            for (i in str) {
                if (i.isUpperCase()) res += "_${i.lowercase()}"
                else res += i
            }
        }

        "2" -> res = str
        "3" -> {
            res = str[0].lowercase()
            for (i in 1 until str.length) {
                if (str[i].isUpperCase()) res += "_${str[i].lowercase()}"
                else res += str[i]
            }
        }
    }

    return res
}

fun PascalCase(case: String, str: String): String {
    var res = ""

    when (case) {
        "1" -> {
            res = str[0].uppercase() + str.substring(1)
        }

        "2" -> {
            res = str[0].uppercase()
            var up = false
            for (i in 1 until str.length) {
                if (up) {
                    res += str[i].uppercase()
                    up = false
                } else if (str[i] == '_') up = true
                else res += str[i]
            }
        }

        "3" -> res = str

    }

    return res
}