import sys

input = sys.stdin.readline

is_zigzag = [0] * 1000001
prefix_sum = [0] * 1000001


def check(n):
    s = str(n)
    length = len(s)
    if length < 3:
        return False

    # 증가 구간
    idx = 0
    while idx + 1 < length and s[idx] < s[idx + 1]:
        idx += 1

    # 증가 또는 감소만 존재
    if idx == 0 or idx == length - 1:
        return False

    # 감소 구간
    while idx + 1 < length and s[idx] > s[idx + 1]:
        idx += 1

    return idx == length - 1


for i in range(1, 1000001):
    if check(i):
        is_zigzag[i] = 1
    prefix_sum[i] = prefix_sum[i - 1] + is_zigzag[i]

t = int(input())
for _ in range(t):
    a, b = map(int, input().split())
    print(prefix_sum[b] - prefix_sum[a - 1])
