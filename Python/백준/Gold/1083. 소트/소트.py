import sys

input = sys.stdin.readline

# 입력 받기
n = int(input())
arr = list(map(int, input().split()))
s = int(input())

for i in range(n):
    if s == 0:
        break

    # 현재 위치(i)에서부터 남은 교환 횟수(s) 내에서 도달 가능한 범위까지 탐색
    max_val = arr[i]
    max_idx = i

    limit = min(n, i + s + 1)
    for j in range(i + 1, limit):
        if arr[j] > max_val:
            max_val = arr[j]
            max_idx = j

    # 찾은 최대값이 현재 위치가 아니라면, 해당 값을 현재 위치로 이동
    if max_idx != i:
        # pop과 insert를 사용하여 원소를 앞으로 이동
        val_to_move = arr.pop(max_idx)
        arr.insert(i, val_to_move)

        # 교환 횟수를 차감
        s -= max_idx - i

# 결과
print(*arr)
