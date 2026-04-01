n, m, k = map(int, input().split())
people = list(input())

for i in range(n):
    if people[i] == 'R':
        left, right = max(0, i - k), min(n - 1, i + k + 1)
        for j in range(left, right):
            people[j] = 'R'
print("Yes" if people.count('R') <= m else "No")