import re
input()
print(sum(list(map(int, re.findall(r"\d+", input())))))