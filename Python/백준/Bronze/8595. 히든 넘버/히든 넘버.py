import sys
import re

input = sys.stdin.readline


n = int(input())
res = sum(list(map(int, re.findall(r"\d+", input()))))

print(res)
