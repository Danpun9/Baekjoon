import sys

input = sys.stdin.readline


def solve():
    time1 = int(input())
    time2 = int(input())
    time3 = int(input())
    time4 = int(input())

    total_seconds = time1 + time2 + time3 + time4
    minutes = total_seconds // 60
    seconds = total_seconds % 60

    print(minutes)
    print(seconds)


solve()
