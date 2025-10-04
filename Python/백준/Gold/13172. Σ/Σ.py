import sys

input = sys.stdin.readline
write = sys.stdout.write

MOD = 1000000007

# 예제 입력
M = int(input())
data = [tuple(map(int, input().split())) for _ in range(M)]

# 기대값 계산
ans = 0
for Ni, Si in data:
    Ni_inv = pow(Ni, MOD - 2, MOD)  # Ni의 모듈러 역원
    val = (Si % MOD) * Ni_inv % MOD
    ans = (ans + val) % MOD

print(ans)
