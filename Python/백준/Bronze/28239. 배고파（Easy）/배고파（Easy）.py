import sys

input = sys.stdin.readline

def solve():
    n = int(input())
    for _ in range(n):
        m = int(input())
        
        if (m & (m - 1)) == 0:
            k = 0
            while (1 << k) < m:
                k += 1
            print(k - 1, k - 1)
        else:
            res = []
            for i in range(63):
                if (m >> i) & 1:
                    res.append(i)
                if len(res) == 2:
                    break
            print(res[0], res[1])

if __name__ == "__main__":
    solve()