import sys
from collections import deque

input = sys.stdin.readline

def solve():
    n, m = map(int, input().split())
    containers = []
    priority_count = [0] * (m + 1)
    
    for _ in range(n):
        p, w = map(int, input().split())
        containers.append((p, w))
        priority_count[p] += 1
        
    queue = deque(containers)
    stack = []
    total_cost = 0
    
    current_p = m
    while queue:
        while current_p > 0 and priority_count[current_p] == 0:
            current_p -= 1
            
        if not queue:
            break
            
        p, w = queue.popleft()
        
        if p < current_p:
            queue.append((p, w))
            total_cost += w
        else:
            temp_stack = []
            move_cost = 0
            
            while stack and stack[-1][0] == p and stack[-1][1] < w:
                target_p, target_w = stack.pop()
                temp_stack.append((target_p, target_w))
                move_cost += target_w
            
            total_cost += w
            total_cost += 2 * move_cost
            
            stack.append((p, w))
            while temp_stack:
                stack.append(temp_stack.pop())
                
            priority_count[p] -= 1

    print(total_cost)

solve()