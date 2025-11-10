import sys

input = sys.stdin.readline


def is_palindrome(s: str) -> bool:
    return s == s[::-1]


def solve():
    s = input().strip()
    n = len(s)

    if not is_palindrome(s):  # 팰린 아님
        print(n)
        return

    if len(set(s)) == 1:  # 팰린 + 모든 문자 동일
        print(-1)

    else:  # 팰린 + 모든 문자 동일x = 1글자만 다르면 팰린x
        print(n - 1)


if __name__ == "__main__":
    solve()
