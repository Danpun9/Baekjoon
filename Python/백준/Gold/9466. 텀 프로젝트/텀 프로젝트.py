import sys

input = sys.stdin.readline

# 재귀 깊이 제한을 늘려줍니다 (N이 클 경우 RecursionError 방지)
sys.setrecursionlimit(110000)


def solve():
    n = int(sys.stdin.readline())
    choices = [0] + list(map(int, sys.stdin.readline().split()))

    # 방문 상태: 0(미방문), 1(방문 중), 2(탐색 완료)
    visited = [0] * (n + 1)
    team_members_count = 0

    def dfs(node):
        nonlocal team_members_count

        visited[node] = 1  # 방문
        path.append(node)

        next_node = choices[node]

        # 사이클 발견
        if visited[next_node] == 1:
            # 사이클 시작점의 인덱스
            cycle_start_index = path.index(next_node)
            # 사이클에 포함된 멤버 수 계산
            team_members_count += len(path) - cycle_start_index

        # 미방문 상태 탐색
        elif visited[next_node] == 0:
            dfs(next_node)

    # 모든 학생 탐색
    for i in range(1, n + 1):
        if visited[i] == 0:
            path = []  # 탐색 경로를 기록
            dfs(i)
            # dfs 종료 후, 현재 경로에 있던 모든 노드는 탐색 완료 상태로 변경
            for node in path:
                if visited[node] == 1:
                    visited[node] = 2

    print(n - team_members_count)


# 테스트 케이스
T = int(sys.stdin.readline())
for _ in range(T):
    solve()
