import sys

input = sys.stdin.readline


def binary_search_count(n, target):
    left, right = 0, n - 1
    count = 0
    while left <= right:
        mid = (left + right) // 2
        if mid == target:
            return count

        # target을 찾지 못했으므로 참조 횟수 1 증가
        count += 1

        if target < mid:
            right = mid - 1
        else:
            left = mid + 1
    return count


def ternary_search_count(n, target):
    left, right = 0, n - 1
    count = 0
    while left <= right:
        left_third = left + (right - left) // 3
        right_third = right - (right - left) // 3

        # 첫 번째 분할점(left_third)에서 찾았을 경우
        if target == left_third:
            return count

        # 두 번째 분할점(right_third)에서 찾았을 경우
        count += 1
        if target == right_third:
            return count

        # 두 분할점에서 모두 찾지 못했을 경우
        count += 1

        if target < left_third:
            right = left_third - 1
        elif target < right_third:
            left = left_third + 1
            right = right_third - 1
        else:
            left = right_third + 1
    return count


def main():
    n = int(input())

    b_less_t = 0
    b_equal_t = 0
    b_greater_t = 0

    # 모든 인덱스에 대해 탐색 횟수를 계산, 비교
    for i in range(n):
        bi = binary_search_count(n, i)
        ti = ternary_search_count(n, i)

        if bi < ti:
            b_less_t += 1
        elif bi == ti:
            b_equal_t += 1
        else:
            b_greater_t += 1

    print(b_less_t)
    print(b_equal_t)
    print(b_greater_t)


if __name__ == "__main__":
    main()
