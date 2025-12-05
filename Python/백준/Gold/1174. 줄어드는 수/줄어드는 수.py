import sys

input = sys.stdin.readline
print = sys.stdout.write


n = int(input())

# 감소하는 수 리스트
decreasing_numbers = []


def backtrack(current_num, last_digit):
    # 현재 수를 리스트에 추가
    decreasing_numbers.append(current_num)

    # 다음 자릿수는 last_digit보다 작아야 함
    for next_digit in range(last_digit - 1, -1, -1):
        new_num = current_num * 10 + next_digit
        backtrack(new_num, next_digit)


# 0부터 9까지 각각을 시작점으로 백트래킹 실행
for start_digit in range(10):
    backtrack(start_digit, start_digit)

# 감소하는 수들을 정렬
decreasing_numbers.sort()

# N번째 감소하는 수 출력
if n - 1 < len(decreasing_numbers):
    print(str(decreasing_numbers[n - 1]))
else:
    print(str(-1))
