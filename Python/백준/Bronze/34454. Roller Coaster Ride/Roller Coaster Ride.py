N = int(input())

C = int(input())

P = int(input())

total_capacity = C * P

if N <= total_capacity:
    print("yes")
else:
    print("no")