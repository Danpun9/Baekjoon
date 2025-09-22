import sys

input = sys.stdin.readline
write = sys.stdout.write

def solve():
    x = int(input())

    if x < 13:
      write(f"{x}\n")
    else:
      write(f"{x+1}\n")

if __name__ == "__main__":
    solve()