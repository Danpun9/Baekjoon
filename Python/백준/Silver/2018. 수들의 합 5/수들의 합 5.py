import sys

input = sys.stdin.readline

n = int(input())

count = 1
start_index = 1
end_index = 1
sum_val = 1

while end_index != n:
    if sum_val == n:
        count += 1
        end_index += 1
        sum_val += end_index
    elif sum_val > n:
        sum_val -= start_index
        start_index += 1
    else:
        end_index += 1
        sum_val += end_index

print(count)