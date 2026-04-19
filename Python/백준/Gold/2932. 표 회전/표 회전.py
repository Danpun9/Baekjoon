import sys

def solve():
    input = sys.stdin.readline
    N, K = map(int, input().split())
    
    queries = []
    targets = set()
    for _ in range(K):
        X, R, C = map(int, input().split())
        queries.append((X, R - 1, C - 1))
        targets.add(X)
        
    pos = {}
    for x in targets:
        pos[x] = [(x - 1) // N, (x - 1) % N]
        
    for X, target_r, target_c in queries:
        curr_r, curr_c = pos[X]
        
        d1 = (target_c - curr_c) % N
        if d1 > 0:
            for p in pos.values():
                if p[0] == curr_r:
                    p[1] = (p[1] + d1) % N
                    
        curr_c = target_c
        
        d2 = (target_r - curr_r) % N
        if d2 > 0:
            for p in pos.values():
                if p[1] == curr_c:
                    p[0] = (p[0] + d2) % N
                    
        print(d1 + d2)

if __name__ == '__main__':
    solve()