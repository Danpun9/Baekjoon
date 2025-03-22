import Foundation

let n = Int(readLine()!)!

var tree = Array(repeating: [Int](), count: n + 1)  // 노드 연결 트리
var parentArr = [Int](0...n)  // 각 노드의 부모
var depthArr = Array(repeating: 0, count: n + 1)  // 각 노드의 깊이

// 트리 연결
for _ in 1..<n {
  let ab = readLine()!.split(separator: " ").map { Int(String($0))! }

  tree[ab[0]].append(ab[1])
  tree[ab[1]].append(ab[0])
}

// 트리 초기화
func treeInit(curr: Int, depth: Int, parent: Int) {
  parentArr[curr] = parent  // 현재 노드의 부모
  depthArr[curr] = depth  // 현재 노드의 깊이

  for next in tree[curr] {
    if next != parent {
      // 다음 노드의 깊이는 현재 노드의 깊이 + 1, 부모는 현재 노드
      treeInit(curr: next, depth: depth + 1, parent: curr)
    }
  }
}

// 트리 초기화
treeInit(curr: 1, depth: 0, parent: 0)

let m = Int(readLine()!)!

// 공통 부모 찾기
func lca(a: Int, b: Int) -> Int {
  var ac = a  // a 노드 포인터
  var bc = b  // b 노드 포인터
  var ad = depthArr[ac]  // a 노드의 깊이
  var bd = depthArr[bc]  // b 노드의 깊이

  // ac와 bc의 깊이를 동일하게 조정
  while ad > bd {  // ac의 깊이가 더 깊음
    ac = parentArr[ac]
    ad -= 1
  }

  while ad < bd {  // bc의 깊이가 더 깊음
    bc = parentArr[bc]
    bd -= 1
  }

  // 동일한 깊이에서 올라가면서 공통 부모 찾기기
  while ac != bc {
    ac = parentArr[ac]
    bc = parentArr[bc]
  }

  return ac
}

// 출력
for _ in 1...m {
  let ab = readLine()!.split(separator: " ").map { Int(String($0))! }

  print(lca(a: ab[0], b: ab[1]))
}
