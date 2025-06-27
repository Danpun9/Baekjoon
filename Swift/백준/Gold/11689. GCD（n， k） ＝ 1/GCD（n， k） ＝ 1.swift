import Foundation

func euler(N: Int64) -> Int64 {
  var n: Int64 = N
  var res = Double(n)

  var p: Int64 = 2
  while p * p <= n {
    if n % p == 0 {
      while n % p == 0 {
        n /= p
      }
      res *= (1.0 - (1.0 / Double(p)))
    }
    p += 1
  }

  if n > 1 {
    res *= (1.0 - (1.0 / Double(n)))
  }

  return Int64(res)
}

let n = Int(readLine()!)!

print(euler(N: Int64(n)))
