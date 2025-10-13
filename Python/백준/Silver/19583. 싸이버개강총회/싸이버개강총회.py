import sys

input = sys.stdin.readline


def solve():
    s, e, q = input().split()

    def time_to_minutes(time_str):
        h, m = map(int, time_str.split(":"))
        return h * 60 + m

    s_min = time_to_minutes(s)
    e_min = time_to_minutes(e)
    q_min = time_to_minutes(q)

    entered = set()  # 입장
    exited = set()  # 퇴장

    while True:
        line = input().strip()
        if not line:
            break

        time_str, nickname = line.split(" ", 1)
        chat_time = time_to_minutes(time_str)

        # 입장: S 이전 또는 S 시간에 채팅
        if chat_time <= s_min:
            entered.add(nickname)

        # 퇴장: E 이후부터 Q까지 채팅
        if e_min <= chat_time <= q_min:
            exited.add(nickname)

    both_confirmed = entered & exited
    print(len(both_confirmed))


if __name__ == "__main__":
    solve()
