import sys

def solve():
    input = sys.stdin.readline
    
    N, M = map(int, input().split())
    
    if N == 0:
        print(0)
        return

    weights = list(map(int, input().split()))
    
    box_count = 1
    current_weight = 0
    
    for weight in weights:
        if current_weight + weight <= M:
            current_weight += weight
        else:
            box_count += 1
            current_weight = weight
            
    print(box_count)

if __name__ == "__main__":
    solve()