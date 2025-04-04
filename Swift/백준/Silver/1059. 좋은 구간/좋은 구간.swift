import Foundation

let l = Int(readLine()!)!

var S = readLine()!.split(separator: " ").map { Int(String($0))! }

let n = Int(readLine()!)!

// 집합 S에 n추가 후 정렬
S.append(n)
S.sort()

var min = 0 // 집합 S의 정수 중 최솟값
var max = 1000 // 집랍 S의 정수 중 최댓값
var isContainN = false

for i in 0 ..< l {
    if S[i] != n { continue }

    if i != 0 { min = S[i - 1] } // n을 사이에 두었을 때 바로 옆 작은 값
    if i != l { max = S[i + 1] } // n을 사이에 두었을 때 바로 옆 큰 값

    if min == n || max == n { isContainN = true } // n 이 집합 안에 포함되어 있다면(n과 동일한 값이 2개) 0 출력

    break
}

var res = 0

if isContainN {
    res = 1 // 집합 S에 n이 포함되어 있음
} else {
    for _ in min + 1 ... n { // 최솟값을 포함하지 않은 구간 구하기
        for _ in n ... max - 1 { // 최댓값을 포함하지 않은 구간 구하기
            res += 1
        }
    }
}

print(res - 1) // [n,n] 구간 미포함
