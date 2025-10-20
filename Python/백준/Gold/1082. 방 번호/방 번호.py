import sys

input = sys.stdin.readline


def solve():
    n = int(input())
    p = list(map(int, input().split()))
    m = int(input())

    # 최대 길이의 방 번호 만들기

    # 가장 저렴한 숫자
    min_cost = float("inf")
    for i in range(n):
        if p[i] <= min_cost:
            min_cost = p[i]

    # 가장 저렴한 숫자 (0 제외)
    min_nonzero_cost = float("inf")
    if n > 1:
        for i in range(1, n):
            if p[i] <= min_nonzero_cost:
                min_nonzero_cost = p[i]

    length = 0
    if m < min_nonzero_cost:  # 가장 저렴한 숫자 (0 제외)가 m보다 큰 경우
        print(0)
        return

    length = 1 + (m - min_nonzero_cost) // min_cost

    # 방 번호 만들기
    room_number = []
    current_m = m
    for i in range(length):
        # 각 자릿수에 대해 가장 큰 숫자부터 시도
        for digit in range(n - 1, -1, -1):
            # 가장 첫 자리 0 방지
            if i == 0 and digit == 0 and length > 1:
                continue

            cost = p[digit]
            remaining_len = length - 1 - i

            # 해당 숫자를 선택했을 때 남은 예산으로 나머지 자릿수를 최소 비용으로 채울 수 있는지 확인
            if current_m >= cost and (current_m - cost) >= remaining_len * min_cost:
                room_number.append(str(digit))
                current_m -= cost
                break

    print("".join(room_number))


solve()
