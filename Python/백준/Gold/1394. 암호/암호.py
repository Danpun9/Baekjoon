import sys

input = sys.stdin.readline


def solve():
    charset = input().strip()
    password = input().strip()

    MOD = 900528
    S = len(charset)
    L = len(password)

    char_to_index = {char: i for i, char in enumerate(charset)}

    # 총 시도 횟수 = password보다 짧은 길이의 경우 + 같은 길이에서 password까지

    # password보다 짧은 길이의 경우
    count_prev_lengths = 0
    current_power = S  # S^1 부터

    for _ in range(L - 1):
        count_prev_lengths = (count_prev_lengths + current_power) % MOD
        current_power = (current_power * S) % MOD

    # 같은 길이에서 password까지 계산
    count_current_length = 0
    for char in password:
        count_current_length = (count_current_length * S + char_to_index[char]) % MOD

    # 총 시도 횟수
    total = (count_prev_lengths + count_current_length + 1) % MOD

    print(total)


if __name__ == "__main__":
    solve()
