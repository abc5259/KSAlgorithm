# 백준_7569 - [그래프]토마토.py (08/08)
import sys
from collections import deque
input = sys.stdin.readline

N, M, H = map(int, input().split())
tomato_farm = [[list(map(int, input().split())) for _ in range(M)] for i in range(H)]
wasdud = ((0, -1, 0), (0, 1, 0), (-1, 0, 0), (1, 0, 0), (0, 0, -1), (0, 0, 1))

def tomato():
    queue = deque()
    for i in range(H):
        for j in range(M):
            for z in range(N):
                if tomato_farm[i][j][z] == 1:
                    queue.append([z, j, i, 0])

    final_day = 0
    while queue:
        x, y, z, days = queue.popleft()

        for xx, yy, zz in wasdud:
            xx += x
            yy += y
            zz += z
            if (0 <= xx < N) and (0 <= yy < M) and (0 <= zz < H):
                if tomato_farm[zz][yy][xx] == 0:
                    final_day = days + 1
                    tomato_farm[zz][yy][xx] = days + 1
                    queue.append([xx, yy, zz, days + 1])

    for i in tomato_farm:
        for j in i:
            if 0 in j:
                final_day = -1
                break
    return final_day

print(tomato())