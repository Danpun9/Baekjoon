import sys
import math

input = sys.stdin.readline

L = int(input())
A = int(input())
B = int(input())
C = int(input())
D = int(input())

homework_days = max(math.ceil(A / C), math.ceil(B / D))

play_days = L - homework_days

print(play_days)
