import Foundation

let n = Int(readLine()!)!

var i = 1
var height = 0
while i <= n {
    height += 1
    i *= 2
}

var tree = Array(repeating: [Int](), count: n + 1)
var parentArr = Array(repeating: [Int](0...height), count: n + 1)
var depthArr = [Int](repeating: 0, count: n + 1)

for _ in 1...n - 1 {
    let ab = readLine()!.split(separator: " ").map(String.init).compactMap(
        Int.init)

    tree[ab[0]].append(ab[1])
    tree[ab[1]].append(ab[0])
}

func initTree(curr: Int, depth: Int, parent: Int) {
    depthArr[curr] = depth
    parentArr[curr][0] = parent

    for next in tree[curr] {
        if next != parent {
            initTree(curr: next, depth: depth + 1, parent: curr)
        }
    }
}

func initParent() {
    for i in 1..<height {
        for j in 1...n {
            parentArr[j][i] = parentArr[parentArr[j][i - 1]][i - 1]
        }
    }
}

initTree(curr: 1, depth: 0, parent: 0)
initParent()

func lca(a: Int, b: Int) -> Int {
    var ac = a
    var bc = b
    let ad = depthArr[ac]
    let bd = depthArr[bc]

    if ad < bd {
        let temp = ac
        ac = bc
        bc = temp
    }

    for i in stride(from: height - 1, to: -1, by: -1) {
        if Int(pow(2.0, Double(i))) <= depthArr[ac] - depthArr[bc] {
            ac = parentArr[ac][i]
        }
    }

    if ac == bc { return ac }

    for i in stride(from: height - 1, to: -1, by: -1) {
        if parentArr[ac][i] != parentArr[bc][i] {
            ac = parentArr[ac][i]
            bc = parentArr[bc][i]
        }
    }

    return parentArr[ac][0]
}

let m = Int(readLine()!)!

var sb = ""

for _ in 1...m {
    let ab = readLine()!.split(separator: " ").map(String.init).compactMap(
        Int.init)
    sb += String(lca(a: ab[0], b: ab[1])) + "\n"
}

print(sb)