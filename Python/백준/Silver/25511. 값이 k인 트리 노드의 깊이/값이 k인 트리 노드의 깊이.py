import sys
from collections import deque

input = sys.stdin.readline

n, k = map(int, input().split())

# 트리
tree = [[] for _ in range(n)]

# 간선
for _ in range(n - 1):
    p, c = map(int, input().split())
    tree[p].append(c)

# 각 정점에 부여된 값
values = list(map(int, input().split()))

# 값이 k인 정점 번호 찾기
target_node = values.index(k)

# BFS로 각 정점의 깊이 계산
depth = [-1] * n
depth[0] = 0
queue = deque([0])

while queue:
    node = queue.popleft()
    for child in tree[node]:
        if depth[child] == -1:
            depth[child] = depth[node] + 1
            queue.append(child)

# 결과
print(depth[target_node])
