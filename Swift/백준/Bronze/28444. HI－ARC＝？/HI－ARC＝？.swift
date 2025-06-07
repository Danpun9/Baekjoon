import Foundation

let n = readLine()!.split(separator: " ").map { Int(String($0))! }

print(n[0]*n[1] - (n[2]*n[3]*n[4]))
