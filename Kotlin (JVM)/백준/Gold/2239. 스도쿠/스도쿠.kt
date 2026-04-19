import java.io.*
import kotlin.system.exitProcess

val bw = BufferedWriter(OutputStreamWriter(System.`out`))
val sudoku = Array(9) { IntArray(9) }

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val temp = Array(9) { br.readLine() }

    for (i in 0..8) {
        for (j in 0..8) {
            sudoku[i][j] = temp[i][j] - '0'
        }
    }

    dfs(0, 0)

    bw.close()
    br.close()
}

fun dfs(x: Int, y: Int) {
    if (x == 9) { // 행 탐색 완료시 다음 행 넘어가기
        dfs(0, y + 1)
        return
    }

    if (y == 9) { // 마지막 도착 시(dfs(8,8) -> dfs(8,9) -> dfs(0,9)) 출력 후 종료
        for (i in sudoku) {
            for (j in i) {
                bw.write("$j")
            }
            bw.write("\n")
        }

        bw.flush()
        exitProcess(0)
    }

    if (sudoku[y][x] != 0) {
        dfs(x + 1, y) // 현재 위치의 값이 0이 아니면 다음 위치로 이동
    } else {
        for (i in 1..9) {
            if (check(x, y, i)) { // 저장 가능한 값이면 저장 후 위치 이동
                sudoku[y][x] = i
                dfs(x + 1, y)
                sudoku[y][x] = 0 // 백트래킹 종료후 값 초기화
            }
        }
    }
}

fun check(x: Int, y: Int, num: Int): Boolean {
    for (i in 0..8) {
        if (num == sudoku[i][x]) return false // 열 중복 체크
        if (num == sudoku[y][i]) return false // 행 중복 체크
    }

    // 현재 x, y 가 속한 3*3칸 중복 체크
    val xx = (x / 3) * 3
    val yy = (y / 3) * 3
    for (i in yy..yy + 2) {
        for (j in xx..xx + 2) {
            if (num == sudoku[i][j]) return false
        }
    }

    return true
}