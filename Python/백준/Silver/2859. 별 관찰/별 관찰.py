import sys

input = sys.stdin.readline

def solve():
    def to_min(s):
        h, m = map(int, s.split(':'))
        return h * 60 + m

    line1 = input().strip()
    if not line1:
        return
    
    t1 = to_min(line1)
    t2 = to_min(input())
    p1 = to_min(input())
    p2 = to_min(input())
    
    days = ["Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"]
    
    found = False
    for i in range(10000):
        cur = t1 + i * p1
        if cur >= t2 and (cur - t2) % p2 == 0:
            d_idx = (cur // 1440) % 7
            hh = (cur % 1440) // 60
            mm = cur % 60
            print(days[d_idx])
            print(f"{hh:02d}:{mm:02d}")
            found = True
            break
            
    if not found:
        print("Never")

solve()