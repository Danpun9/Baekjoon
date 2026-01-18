import sys

input = sys.stdin.readline

a = 0
b = 0

for i in range(1, 10):
    print(f"? A {i}", flush=True)

    answer = int(input())
    if answer == 1:
        a = i
        break

for i in range(1, 10):
    print(f"? B {i}", flush=True)

    answer = int(input())
    if answer == 1:
        b = i
        break

print(f"! {a + b}")
