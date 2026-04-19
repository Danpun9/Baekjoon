import sys

input = sys.stdin.readline


s,t = map(int, input().split())

def cnt(x):
    ret = 0
    for i in range(1,x+1):
        if i % 2 == 0:
            ret += x//i
        else:
            ret -= x//i
    
    return ret

print(cnt(t)-cnt(s-1))
