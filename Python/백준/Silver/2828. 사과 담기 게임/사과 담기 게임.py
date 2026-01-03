import sys

input = sys.stdin.readline

n, m = map(int, input().split())
j = int(input())

left = 1
right = m
total_dist = 0

for _ in range(j):
    apple_pos = int(input())
    
    if apple_pos < left:
        dist = left - apple_pos
        total_dist += dist
        left -= dist
        right -= dist
    elif apple_pos > right:
        dist = apple_pos - right
        total_dist += dist
        right += dist
        left += dist

print(total_dist)