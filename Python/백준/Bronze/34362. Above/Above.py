import sys

input = sys.stdin.readline

def solve():
    altitude = float(input().strip())
    adjusted_altitude = altitude - 0.3
    print(f"{adjusted_altitude:.4f}")

if __name__ == "__main__":
    solve()