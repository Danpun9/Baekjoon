import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    var (n, k) = br.readLine().split(" ").map { it.toInt() }

    var res = 0

    while (n.countOneBits() > k) { // 이진수 n의 1의 개수 == 현재 n으로 만들 수 있는 최소한의 물병 개수
        res += n and (-n) // 구매한 물병 더하기
        n += n and (-n) // 가장 왼쪽 비트 옮기기
    }

    bw.write("$res\n")

    bw.close()
    br.close()
}
/*
input
1000000 5

n = 1000000
k = 5

n을 이진수로 변환하면
11110100001001000000

1의 개수가 k보다 많으면 물병을 추가로 구매해야 함

이 때 구매할 물병의 개수는 가장 왼쪽의 비트를 옮길 만큼 구매해야 한다.
가장 왼쪽의 1의 비트를 옮기기 위해서 n & (-n)을 해줌

n(2)    == 00000000000011110100001001000000
(-n)(2) == 11111111111100001011110111000000
n&(-n)  == 00000000000000000000000001000000

물병을 64개 구매하면 가장 왼쪽의 1을 옮길 수 있다.

res += 64
n = 11110100001010000000

이를 반복하여 1의 개수가 k개 이하가 될 때 까지 진행한다.

res += 128
n = 11110100001010000000

res += 256
n = 11110100001100000000

res += 1024
n = 11110100010000000000

res += 2048
n = 11110100100000000000

res += 4096
n = 11110101000000000000

res += 8192
n = 11110110000000000000

res == 15808
*/