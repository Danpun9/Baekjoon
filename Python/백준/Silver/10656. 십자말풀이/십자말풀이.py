import sys

input = sys.stdin.readline

N, M = map(int, input().split())
grid = [input().strip() for _ in range(N)]

clues = []

for r in range(N):
    for c in range(M):
        if grid[r][c] == '#':
            continue
        
        is_clue = False
        
        if (c == 0 or grid[r][c-1] == '#') and (c + 2 < M and grid[r][c+1] == '.' and grid[r][c+2] == '.'):
            is_clue = True
            
        if not is_clue:
            if (r == 0 or grid[r-1][c] == '#') and (r + 2 < N and grid[r+1][c] == '.' and grid[r+2][c] == '.'):
                is_clue = True
                
        if is_clue:
            clues.append((r + 1, c + 1))

print(len(clues))
for r, c in clues:
    print(f"{r} {c}")