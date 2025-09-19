import sys

input = sys.stdin.readline

# 입력
E, S, M = map(int, input().split())

# 주기
e_period = 15
s_period = 28
m_period = 19


max_year = e_period * s_period * m_period  # 최대

# 조건을 만족하는 연도 찾기
for year in range(1, max_year + 1):
    current_e = ((year - 1) % e_period) + 1
    current_s = ((year - 1) % s_period) + 1
    current_m = ((year - 1) % m_period) + 1

    if current_e == E and current_s == S and current_m == M:
        print(year)
        break
