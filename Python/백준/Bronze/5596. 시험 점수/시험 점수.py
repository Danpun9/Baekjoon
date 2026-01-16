minkook_scores = list(map(int, input().split()))
S = sum(minkook_scores)

manse_scores = list(map(int, input().split()))
T = sum(manse_scores)

print(max(S, T))