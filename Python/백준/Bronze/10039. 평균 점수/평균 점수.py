import sys

def solve():
    
    scores = []
    for _ in range(5):
        score = int(sys.stdin.readline().strip())
        scores.append(score)
        
    total_sum = 0
    for score in scores:
        if score < 40:
            adjusted_score = 40
        else:
            adjusted_score = score
            
        total_sum += adjusted_score

    average_score = total_sum // 5
    print(average_score)

if __name__ == "__main__":
    solve()

