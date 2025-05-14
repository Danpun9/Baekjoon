import Foundation

let t = Int(String(readLine()!))!

for _ in 0 ..< t {
    let n = Int(String(readLine()!))!

    if n == 1 { print(0) }
    else { print("1" + String(repeating: "2", count: n - 2) + "1") }
}
