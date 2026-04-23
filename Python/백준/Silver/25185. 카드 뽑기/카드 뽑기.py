import sys
from collections import Counter

input = sys.stdin.readline

T = int(input())
for _ in range(T):
    cards = input().split()
    counts = Counter(cards)
    
    rest = False
    pair_count = 0
    
    for v in counts.values():
        if v >= 3:
            rest = True
        pair_count += v // 2
        
    if pair_count == 2:
        rest = True
        
    card_set = set(cards)
    for alpha in 'mps':
        for n in range(1, 8):
            if f"{n}{alpha}" in card_set and f"{n+1}{alpha}" in card_set and f"{n+2}{alpha}" in card_set:
                rest = True
                
    if rest:
        print(":)")
    else:
        print(":(")