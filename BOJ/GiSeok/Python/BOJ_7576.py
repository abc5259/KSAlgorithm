# 백준 - 7576 [그래프]토마토.py (08/02)
from collections import deque
import sys
input = sys.stdin.readline

M, N = map(int, input().split())
wasd = ((-1, 0), (1, 0), (0, -1), (0, 1))
graph = [list(map(int, input().split())) for _ in range(N)]


def tomato():
    queue = deque()
    for y in range(N):
        for x in range(M):
            if graph[y][x] == 1:
                queue.append([x, y, 0])

    final_day = 0
    while queue:
        xx, yy, day = queue.popleft()

        for yi, xi in wasd:
            hx = xx + xi
            hy = yy + yi
            if ((hx >= 0) and (hx < M)) and ((hy >= 0) and (hy < N)):
                if graph[hy][hx] == 0:
                    graph[hy][hx] = day + 1
                    final_day = day + 1
                    queue.append([hx, hy, day+1])

    for lt in graph:
        if 0 in lt:
            final_day = -1
            break

    return final_day


print(tomato())