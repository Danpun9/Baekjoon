import sys

input = sys.stdin.readline
write = sys.stdout.write


def solve():
    N, L = map(int, input().split())
    
    # L부터 100까지 길이를 시도
    for length in range(L, 101):
        # 연속된 수의 합 공식: length * first + length * (length-1) / 2 = N
        # first = (N - length * (length-1) / 2) / length
        
        numerator = N - length * (length - 1) // 2
        
        # 나누어떨어지지 않으면 불가능
        if numerator % length != 0:
            continue
        
        first_num = numerator // length

        # 첫 번째 수가 음이 아닌지 확인
        if first_num >= 0:
            result = [first_num + i for i in range(length)]
            write(' '.join(map(str, result)) + "\n")
            return
    
    write("-1\n")

if __name__ == "__main__":
    solve()
