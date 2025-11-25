import sys

input = sys.stdin.readline


def solve():
    n = int(input().strip())
    s = input().strip()

    prev = "["
    cnt = 0

    for i in range(1, n):
        if prev == "[":
            cnt += 1
        elif prev == "]" and (s[i] == "2" or s[i] == "5" or s[i] == "]"):
            cnt += 1
        elif prev == "2" and (s[i] == "5" or s[i] == "[" or s[i] == "]"):
            cnt += 1
        elif prev == "5" and (s[i] == "2" or s[i] == "[" or s[i] == "]"):
            cnt += 1
        elif (prev == "2" and s[i] == "2") or (prev == "5" and s[i] == "5"):
            cnt += 2

        prev = s[i]

    print(cnt)


if __name__ == "__main__":
    solve()
