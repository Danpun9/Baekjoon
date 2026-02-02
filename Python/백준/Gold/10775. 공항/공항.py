import sys

sys.setrecursionlimit(10**6)
input = sys.stdin.readline


g = int(input())
p = int(input())

cnt = 0
parent = list(range(g+1))
planes = [int(input()) for _ in range(p)]


def find(x):
    if parent[x] == x:
        return x
    parent[x] = find(parent[x])
    return parent[x]

def union(a,b):
    pa = find(a)
    pb = find(b)
    if pa != pb:
        parent[pa] = pb



for gi in planes:
    gate = find(gi)

    if gate == 0:
        break

    union(gate, gate-1)
    cnt += 1

print(cnt)