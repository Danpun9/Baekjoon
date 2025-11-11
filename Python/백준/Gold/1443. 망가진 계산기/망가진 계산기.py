import sys


input = sys.stdin.readline


D, P = map(int, input().split())


max_val = 10**D  # D자릿수 이하 최대 한계


if P == 0:  # P가 0이면 곱셈x
    print(1)
    exit(0)

# dp[k] = k번 곱셈으로 가능한 수 set
dp = [set() for _ in range(P + 1)]
dp[0] = {1}

for k in range(1, P + 1):  #  P번 곱셈 수행
    for num in dp[k - 1]:  # k번 곱셈의 결과는 (k-1)번 곱셈의 결과로부터 나옴
        for m in range(2, 10):  # 2부터 9까지의 수 곱함

            result = num * m

            if result < max_val:  # 곱한 결과가 D자릿수 이하면 결과 set에 추가
                dp[k].add(result)

    # k번째 단계에서 유효 수 없으면 조기 종료
    if not dp[k]:
        print(-1)
        exit(0)


if not dp[P]:  # 유효한 수x
    print(-1)
else:  # 유효 값 중 최댓값
    print(max(dp[P]))
