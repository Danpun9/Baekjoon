import sys
import random

input = sys.stdin.readline

a = 0
b = 0

num_list = list(range(1, 10001))
random.shuffle(num_list)

while True:
    a = num_list.pop()
    print(f"? A {a}", flush=True)
    resp = int(input())

    if resp == 1:
        break

num_list = list(range(1, 10001))
random.shuffle(num_list)

while True:
    b = num_list.pop()
    print(f"? B {b}", flush=True)
    resp = int(input())

    if resp == 1:
        break

print(f"! {a + b}")
