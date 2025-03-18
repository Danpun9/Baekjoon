import sys
from sys import stdout

input = sys.stdin.readline

# 월
month = {
    "January": 1,
    "February": 2,
    "March": 3,
    "April": 4,
    "May": 5,
    "June": 6,
    "July": 7,
    "August": 8,
    "September": 9,
    "October": 10,
    "November": 11,
    "December": 12,
}

# 각 월에 대한 일
day = [0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]


# 윤년 계산
def isLeapYear(y):
    if y % 400 == 0:
        return True
    elif y % 4 == 0 and y % 100 != 0:
        return True

    return False


cmd = input().split()

mm = month[cmd[0]]  # 월

dd = int(cmd[1][:-1])  # 일

yyyy = int(cmd[2])  # 연도

HH, MM = map(int, cmd[3].split(":"))  # 시간

# 윤년이면 2월을 29로 변경
if isLeapYear(yyyy):
    day[2] = 29

# 해당 연도의 총 시간(분)
total = sum(day) * 24 * 60

# 입력된 시간에 대한 시간(분) 계산
curr = ((sum(day[:mm]) + dd - 1) * 24 * 60) + (HH * 60) + MM

# 백분율 계산
stdout.write(str(curr / total * 100))
