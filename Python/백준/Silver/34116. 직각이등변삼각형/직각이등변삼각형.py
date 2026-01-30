import sys

input = sys.stdin.readline

def solve():
    n = int(input())
    
    u_max = -float('inf')
    u_min = float('inf')
    v_max = -float('inf')
    v_min = float('inf')
    y_max = -float('inf')
    y_min = float('inf')
    
    for _ in range(n):
        x, y = map(int, input().split())
        u = y + x
        v = y - x
        
        if u > u_max: u_max = u
        if u < u_min: u_min = u
        if v > v_max: v_max = v
        if v < v_min: v_min = v
        if y > y_max: y_max = y
        if y < y_min: y_min = y
        
    ans_up = u_max + v_max - 2 * y_min
    ans_down = 2 * y_max - u_min - v_min
    
    print(min(ans_up, ans_down))

if __name__ == "__main__":
    solve()