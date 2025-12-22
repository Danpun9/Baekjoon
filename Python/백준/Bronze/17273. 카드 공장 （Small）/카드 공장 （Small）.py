import sys

def solve():
    n, m = map(int, sys.stdin.readline().split())
    
    cards = []
    for _ in range(n):
        a, b = map(int, sys.stdin.readline().split())
        cards.append({'front': a, 'back': b, 'current': a})
    
    for _ in range(m):
        k = int(sys.stdin.readline())
        
        for card in cards:
            if card['current'] <= k:
                if card['current'] == card['front']:
                    card['current'] = card['back']
                else:
                    card['current'] = card['front']
    
    total_sum = sum(card['current'] for card in cards)
    print(total_sum)

if __name__ == "__main__":
    solve()