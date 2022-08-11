# 백준_2468 - [브루트 포스]안전 영역 (08/12)
import sys
sys.setrecursionlimit(10000)
input = sys.stdin.readline

N = int(input())
rain_map = [list(map(int, input().split())) for _ in range(N)]
wasd = ((0, -1), (0, 1), (-1, 0), (1, 0))

def dfs(x, y, rain):
    visited[y][x] = True

    for hx, hy in wasd:
        hx += x
        hy += y

        if (0 <= hx < N) and (0 <= hy < N):
            if not visited[hy][hx] and rain < rain_map[hy][hx]:
                dfs(hx, hy, rain)

ans = 0
for i in range(0, 101):
    visited = [[False]*N for _ in range(N)]
    cnt = 0
    for j in range(N):
        for z in range(N):
            if not visited[j][z] and i < rain_map[j][z]:
                dfs(z, j, i)
                cnt += 1
    if cnt > ans:
        ans = cnt

print(ans)