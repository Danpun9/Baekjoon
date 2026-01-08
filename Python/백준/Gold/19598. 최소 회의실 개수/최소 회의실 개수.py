import sys
import heapq

input = sys.stdin.readline

N = int(input())
meetings = [list(map(int, input().split())) for _ in range(N)]

meetings.sort()

rooms = []
heapq.heappush(rooms, meetings[0][1])

for i in range(1, N):
    if meetings[i][0] >= rooms[0]:
        heapq.heappop(rooms)
    heapq.heappush(rooms, meetings[i][1])

print(len(rooms))