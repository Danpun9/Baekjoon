def solve():
    n, k = map(int, input().split())
    arr = list(map(int, input().split()))

    left = 0
    max_length = 0
    odd_count = 0

    for right in range(n):
        # 현재 원소가 홀수면 홀수 카운트 증가
        if arr[right] % 2 == 1:
            odd_count += 1

        # 홀수 개수가 k를 초과하면 left 포인터 이동
        while odd_count > k:
            if arr[left] % 2 == 1:
                odd_count -= 1
            left += 1

        # 현재 윈도우에서 짝수로만 이루어진 부분 수열의 길이 계산
        current_length = (right - left + 1) - odd_count
        max_length = max(max_length, current_length)

    print(max_length)


if __name__ == "__main__":
    solve()
