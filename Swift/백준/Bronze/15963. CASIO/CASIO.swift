import Foundation

let a = readLine()!.split(separator: " ").map { Int($0)! }

if a[0] == a[1] {
    print(1)
} else {
    print(0)
}
