import Foundation

_ = readLine()
let aStr = readLine()!
let bStr = readLine()!

if aStr == "0" || bStr == "0" {
  print("0")
  exit(0)
}

let aDigits = aStr.reversed().map { Int(String($0))! }
let bDigits = bStr.reversed().map { Int(String($0))! }

var result = [Int](repeating: 0, count: aDigits.count + bDigits.count) // 곱셈 최대 a 자리수 + b 자리수

// 각 자리수 끼리 저장 후 위치에 저장
for i in 0..<aDigits.count {
  for j in 0..<bDigits.count {
    result[i + j] += aDigits[i] * bDigits[j]
  }
}

// 자리수 올림
for k in 0..<result.count - 1 {
  let carry = result[k] / 10
  result[k + 1] += carry
  result[k] %= 10
}

// 출력 만들기
var resultString = ""
var isLeadingZero = true
for num in result.reversed() {
  if isLeadingZero, num == 0 { // 가장 앞에 오는 0은 continue
    continue
  }
  isLeadingZero = false
  resultString += String(num)
}

print(resultString)
