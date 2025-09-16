import sys

input = sys.stdin.readline

class SegmentTree:
    def __init__(self, arr):
        self.n = len(arr)
        self.size = 1
        while self.size < self.n:
            self.size *= 2
        self.tree = [(float("inf"), -1)] * (2 * self.size)

        # 리프 노드 초기화
        for i in range(self.n):
            self.tree[self.size + i] = (arr[i], i)

        # 내부 노드 초기화
        for i in range(self.size - 1, 0, -1):
            left = self.tree[2 * i]
            right = self.tree[2 * i + 1]
            if left[0] < right[0] or (left[0] == right[0] and left[1] < right[1]):
                self.tree[i] = left
            else:
                self.tree[i] = right

    def update(self, pos, value):
        pos += self.size
        self.tree[pos] = (value, pos - self.size)
        pos //= 2

        while pos >= 1:
            left = self.tree[2 * pos]
            right = self.tree[2 * pos + 1]
            if left[0] < right[0] or (left[0] == right[0] and left[1] < right[1]):
                self.tree[pos] = left
            else:
                self.tree[pos] = right
            pos //= 2

    def query(self, l, r):
        l += self.size
        r += self.size
        result = (float("inf"), -1)

        while l <= r:
            if l % 2 == 1:
                if self.tree[l][0] < result[0] or (
                    self.tree[l][0] == result[0] and self.tree[l][1] < result[1]
                ):
                    result = self.tree[l]
                l += 1
            if r % 2 == 0:
                if self.tree[r][0] < result[0] or (
                    self.tree[r][0] == result[0] and self.tree[r][1] < result[1]
                ):
                    result = self.tree[r]
                r -= 1
            l //= 2
            r //= 2

        return result[1] + 1  # 1-based 인덱스 변환


# 입력
N = int(input())
arr = list(map(int, input().split()))
M = int(input())

# 세그먼트 트리
st = SegmentTree(arr)

res = []

# 쿼리 처리
for _ in range(M):
    query = list(map(int, input().split()))

    if query[0] == 1:  # 업데이트
        i, v = query[1], query[2]
        st.update(i - 1, v)  # 0-based 변환
    else:  # 구간 최솟값 인덱스
        i, j = query[1], query[2]
        res.append(st.query(i - 1, j - 1))  # 0-based 변환

for r in res:
    print(r)
