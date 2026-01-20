import sys

low, high = 1, 10**9

while True:
    line = sys.stdin.readline()
    if not line:
        break

    try:
        x = int(line.strip())
    except ValueError:
        break

    if x < low:
        print(">")
    elif x > high:
        print("<")
    else:
        if x - low >= high - x:
            if x == low:
                print("=")
            else:
                print("<")
                high = x - 1
        else:
            if x == high:
                print("=")
            else:
                print(">")
                low = x + 1
    sys.stdout.flush()
