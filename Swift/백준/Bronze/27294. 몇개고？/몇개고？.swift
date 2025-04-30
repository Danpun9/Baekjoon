import Foundation

let t = readLine()!.split(separator: " ").map { Int(String($0))! }

if t[1] == 1 || t[0] <= 11 || t[0] >= 17 { print(280) }
else { print(320) }
