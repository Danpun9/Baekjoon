import sys

input = sys.stdin.readline

while True:
    name, old, height = input().split()
    if name == "#" and old == "0" and height == "0":
        break

    if int(old) > 17 or int(height) >= 80:
        print(name, "Senior")
    else:
        print(name, "Junior")
