def decode_quadtree(s, size):
    def parse(s, index, x, y, size, grid):
        if s[index[0]] == "B":
            for i in range(size):
                for j in range(size):
                    grid[y + i][x + j] = 1
            index[0] += 1
        elif s[index[0]] == "W":
            for i in range(size):
                for j in range(size):
                    grid[y + i][x + j] = 0
            index[0] += 1
        elif s[index[0]] == "Q":
            index[0] += 1
            half = size // 2
            parse(s, index, x, y, half, grid)
            parse(s, index, x + half, y, half, grid)
            parse(s, index, x, y + half, half, grid)
            parse(s, index, x + half, y + half, half, grid)

    grid = [[0] * size for _ in range(size)]
    index = [0]
    parse(s, index, 0, 0, size, grid)
    return grid


def grid_to_xbm(grid, n):
    result = []
    result.append(f"#define quadtree_width {n}")
    result.append(f"#define quadtree_height {n}")
    result.append("static char quadtree_bits[] = {")

    for row in grid:
        hex_values = []
        for i in range(0, n, 8):
            byte_val = 0
            for j in range(8):
                if i + j < n and row[i + j] == 1:
                    byte_val += 1 << j
            hex_values.append(f"0x{byte_val:02x}")
        result.append(",".join(hex_values) + ",")

    result.append("};")
    return result


n = int(input())
s = input().strip()

grid = decode_quadtree(s, n)
output = grid_to_xbm(grid, n)

for line in output:
    print(line)
