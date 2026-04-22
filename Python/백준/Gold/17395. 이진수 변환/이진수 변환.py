import sys

x0, n = map(int, sys.stdin.readline().split())

binary = bin(x0)[2:]
ones_count = binary.count('1')

if n > ones_count:
    print(-1)
else:
    bits = []
    for i, bit in enumerate(reversed(binary)):
        if bit == '1':
            bits.append(1 << i)
    
    bits.sort(reverse=True)
    
    ans = []
    current = x0
    for i in range(n - 1):
        current -= bits[i]
        ans.append(current)
    ans.append(0)
    
    print(*ans)