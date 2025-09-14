import sys
import heapq

input = sys.stdin.readline

T = int(input())
for _ in range(T):
    M = int(input())
    nums = []
    while len(nums) < M:
        nums += list(map(int, input().split()))

    left, right = [], []
    result = []

    for i in range(M):
        n = nums[i]
        if len(left) == len(right):
            heapq.heappush(left, -n)
        else:
            heapq.heappush(right, n)

        if right and -left[0] > right[0]:
            heapq.heappush(left, -heapq.heappop(right))
            heapq.heappush(right, -heapq.heappop(left))

        if i % 2 == 0:
            result.append(-left[0])

    print(len(result))
    for i in range(0, len(result), 10):
        print(*result[i : i + 10])
