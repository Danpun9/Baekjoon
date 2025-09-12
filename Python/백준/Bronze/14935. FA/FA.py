def F(x):
    x_str = str(x)
    first_digit = int(x_str[0])
    digit_count = len(x_str)
    return first_digit * digit_count


def is_fa_number(x):
    visited = set()
    current = x

    while current not in visited:
        visited.add(current)
        next_val = F(current)

        # 동일한 수가 나오면 FA수
        if next_val == current:
            return True

        current = next_val

    # 순환 발견한 경우
    return True


def solve():
    x = int(input())
    if is_fa_number(x):
        print("FA")
    else:
        print("NFA")


if __name__ == "__main__":
    solve()
