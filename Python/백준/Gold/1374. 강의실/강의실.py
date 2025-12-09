import sys
import heapq


input = sys.stdin.read


def solve():
    data = input().split()
    if not data:
        return

    N = int(data[0])

    lectures = []
    data_idx = 1
    
    for _ in range(N):
        _ = int(data[data_idx])
        start = int(data[data_idx + 1])
        end = int(data[data_idx + 2])
        lectures.append((start, end))
        data_idx += 3

    lectures.sort(key=lambda x: x[0])

    classroom_ends = []

    for start, end in lectures:
        if classroom_ends and classroom_ends[0] <= start: # 기존 강의실의 종료 시간을 제거
            heapq.heappop(classroom_ends)
            heapq.heappush(classroom_ends, end)
        else: # 재사용 가능한 강의실이 없음
            heapq.heappush(classroom_ends, end)
            
    print(len(classroom_ends))

if __name__ == "__main__":
    solve()