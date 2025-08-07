import sys

input = sys.stdin.readline

str = input()

for i in range(len(str)):
    if str[:2] == "pi" or str[:2] == "ka":
        str = str[2:]
    elif str[:3] == "chu":
        str = str[3:]
    elif str[:2] == "\n" or str == "":
        break
    else:
        print("NO")
        exit()
print("YES")
