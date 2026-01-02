import sys

input = sys.stdin.readline

N = int(input())
color = list(map(int, input().split()))

possible = True
for i in range(N):
    if color[i] == 0:
        for c in range(1, 4):
            if (i > 0 and color[i-1] == c) or (i < N - 1 and color[i+1] == c):
                continue
            color[i] = c
            break
        else:
            possible = False
            break
    else:
        if (i > 0 and color[i] == color[i-1]) or (i < N - 1 and color[i] == color[i+1]):
            possible = False
            break

if possible:
    print(*(color))
else:
    print(-1)