import sys

input = sys.stdin.readline

def solve():
    n, m = map(int, input().split())
    trains = [0] * (n + 1)
    mask = (1 << 20) - 1

    for _ in range(m):
        command = list(map(int, input().split()))
        
        if command[0] == 1:
            trains[command[1]] |= (1 << (command[2] - 1))
        elif command[0] == 2:
            trains[command[1]] &= ~(1 << (command[2] - 1))
        elif command[0] == 3:
            trains[command[1]] <<= 1
            trains[command[1]] &= mask
        elif command[0] == 4:
            trains[command[1]] >>= 1

    states = set()
    for i in range(1, n + 1):
        states.add(trains[i])
    
    print(len(states))

solve()