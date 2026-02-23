import sys
from collections import deque


def solve():
    n = int(sys.stdin.readline())
    lines = []
    for _ in range(n):
        line_info = list(map(int, sys.stdin.readline().split()))
        lines.append(set(line_info[1:]))

    destination = int(sys.stdin.readline())

    # 0번 역 목적지
    if destination == 0:
        print(0)
        return

    # BFS
    queue = deque()
    visited_lines = [False] * n

    for i in range(n):
        if 0 in lines[i]:
            queue.append((i, 0))  # (노선 인덱스, 환승 횟수)
            visited_lines[i] = True

    while queue:
        curr_line_idx, transfers = queue.popleft()

        if destination in lines[curr_line_idx]:
            print(transfers)
            return

        for station in lines[curr_line_idx]:
            for next_line_idx in range(n):
                if not visited_lines[next_line_idx] and station in lines[next_line_idx]:
                    visited_lines[next_line_idx] = True
                    queue.append((next_line_idx, transfers + 1))

    print(-1)

solve()