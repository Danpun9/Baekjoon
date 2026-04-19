import sys

input = sys.stdin.readline
write = sys.stdout.write

x = input().strip()
time = 0

while len(x) > 1:
    digit_sum = sum(int(digit) for digit in x)
    x = str(digit_sum)
    time += 1

final_digit = int(x)
is_multiple_of_3 = final_digit in [3, 6, 9]

print(time)
print("YES" if is_multiple_of_3 else "NO")
