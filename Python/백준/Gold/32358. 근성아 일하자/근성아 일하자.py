import sys
from bisect import bisect_left

input = sys.stdin.readline

N = int(input())

trash_set = set()
pos = 0
total_dist = 0

for _ in range(N):
    query = input().split()
    
    if query[0] == '1':
        trash_set.add(int(query[1]))
    else:
        if not trash_set:
            continue
            
        A = sorted(list(trash_set))
        trash_set.clear()
        
        R = bisect_left(A, pos)
        L = R - 1
        
        while L >= 0 or R < len(A):
            if L < 0:
                total_dist += A[R] - pos
                pos = A[R]
                R += 1
            elif R >= len(A):
                total_dist += pos - A[L]
                pos = A[L]
                L -= 1
            else:
                dist_L = pos - A[L]
                dist_R = A[R] - pos
                
                if dist_L <= dist_R:
                    total_dist += dist_L
                    pos = A[L]
                    L -= 1
                else:
                    total_dist += dist_R
                    pos = A[R]
                    R += 1

print(total_dist)