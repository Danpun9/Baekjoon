import sys

input = sys.stdin.readline


def calculate_laser_intensity(x1, x2, a, b, c, d, e):
    # f(x) - g(x) = ax² + (b-d)x + (c-e)
    # 적분: a/3 * x³ + (b-d)/2 * x² + (c-e) * x

    # x2
    value_at_x2 = (a / 3) * (x2**3) + ((b - d) / 2) * (x2**2) + (c - e) * x2

    # x1
    value_at_x1 = (a / 3) * (x1**3) + ((b - d) / 2) * (x1**2) + (c - e) * x1

    # 적분값 = F(x2) - F(x1)
    result = value_at_x2 - value_at_x1

    return int(result)


# 입력
x1, x2 = map(int, input().split())
a, b, c, d, e = map(int, input().split())

# 출력
intensity = calculate_laser_intensity(x1, x2, a, b, c, d, e)
print(intensity)
