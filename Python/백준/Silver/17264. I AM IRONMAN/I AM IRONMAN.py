import sys

input = sys.stdin.readline

N, P = map(int, input().split())
W, L, G = map(int, input().split())

# 해킹으로 알게 된 플레이어 정보
result_dict = {}
for _ in range(P):
    name, result = input().split()
    result_dict[name] = result

# N번의 게임 플레이어 이름을 입력받아 게임 진행
score = 0
success = False
for _ in range(N):
    partner = input().strip()
    # 해킹 목록에 있는지 확인
    if partner in result_dict:
        if result_dict[partner] == "W":
            score += W
        else:
            score -= L
            if score < 0:
                score = 0
    else:
        # 해킹 정보 없으면 무조건 짐
        score -= L
        if score < 0:
            score = 0
    # 이미 G점을 넘었는지 확인, 넘으면 break
    if score >= G:
        success = True
        break

# 결과
if success:
    print("I AM NOT IRONMAN!!")
else:
    print("I AM IRONMAN!!")
