case = 1

while True:
    N = int(input().strip())

    if N == 0:
        break

    graph = {}

    for _ in range(N):
        giver, receiver = input().strip().split()
        graph[giver] = receiver

    visited = set()

    res = 0

    for person in graph:
        if person not in visited:
            res += 1
            current = person

            while current not in visited:
                visited.add(current)
                current = graph[current]

    print(f"{case} {res}")

    case += 1
