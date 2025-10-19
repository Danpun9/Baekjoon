import sys

input = sys.stdin.readline

import sys


def solve():
    x = int(sys.stdin.readline())
    queue = list(sys.stdin.readline().strip())

    men_inside = 0
    women_inside = 0

    while queue:
        # 첫 번째 사람 입장
        can_admit_p1 = False
        diff_after_p1 = -1

        p1 = queue[0]
        if p1 == "M":  # 남자일 경우
            if abs((men_inside + 1) - women_inside) <= x:
                can_admit_p1 = True
                diff_after_p1 = abs((men_inside + 1) - women_inside)
        else:  # 여자일 경우
            if abs(men_inside - (women_inside + 1)) <= x:
                can_admit_p1 = True
                diff_after_p1 = abs(men_inside - (women_inside + 1))

        # 두 번째 사람 입장
        can_admit_p2 = False
        diff_after_p2 = -1

        if len(queue) > 1:
            p2 = queue[1]
            if p2 == "M":  # 남자일 경우
                if abs((men_inside + 1) - women_inside) <= x:
                    can_admit_p2 = True
                    diff_after_p2 = abs((men_inside + 1) - women_inside)
            else:  # 여자일 경우
                if abs(men_inside - (women_inside + 1)) <= x:
                    can_admit_p2 = True
                    diff_after_p2 = abs(men_inside - (women_inside + 1))

        if not can_admit_p1 and not can_admit_p2:  # 더 이상 아무도 입장시킬 수 없음
            break
        elif can_admit_p1 and not can_admit_p2:  # 첫 번째 사람만 입장 가능
            if queue[0] == "M":
                men_inside += 1
            else:
                women_inside += 1
            queue.pop(0)
        elif not can_admit_p1 and can_admit_p2:  # 두 번째 사람만 입장 가능
            if queue[1] == "M":
                men_inside += 1
            else:
                women_inside += 1
            queue.pop(1)
        else:
            # 두 사람 모두 입장 가능한 경우: 성비 차이를 더 크게 만드는 쪽을 선택
            if diff_after_p1 >= diff_after_p2:
                if queue[0] == "M":
                    men_inside += 1
                else:
                    women_inside += 1
                queue.pop(0)
            elif diff_after_p2 > diff_after_p1:
                if queue[1] == "M":
                    men_inside += 1
                else:
                    women_inside += 1
                queue.pop(1)

    # 결과
    print(men_inside + women_inside)


solve()
