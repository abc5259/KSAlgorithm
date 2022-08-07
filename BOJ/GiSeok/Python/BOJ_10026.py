# 백준 - 10026 [그래프]적록색약.py (08/07)
import sys, copy
from collections import deque
sys.setrecursionlimit(10000)
input = sys.stdin.readline

N = int(input())
grid = [list(input().rstrip()) for _ in range(N)]
visited = [[False]*N for _ in range(N)]
wasd = ((0, -1), (0, 1), (-1, 0), (1, 0))

def dfs(x, y, color):
    visited[y][x] = True

    for hx, hy in wasd:
        hx += x
        hy += y

        if (hx >= 0 and hx < N) and (hy >= 0 and hy < N):
            if not visited[hy][hx] and grid[hy][hx] == color:
                dfs(hx, hy, color)

def bfs(blindess):
    queue = deque()
    copy_visited = copy.deepcopy(visited)

    cnt = 0
    for i in range(N):
        for j in range(N):
            if not copy_visited[i][j]:
                queue.append([j, i])
                copy_visited[i][j] = True

                while queue:
                    xx, yy = queue.popleft()

                    for hx, hy in wasd:
                        hx += xx
                        hy += yy

                        if (hx >= 0 and hx < N) and (hy >= 0 and hy < N):
                            if blindess and (not copy_visited[hy][hx]):
                                if grid[yy][xx] == 'G' or grid[yy][xx] == 'R':
                                    if grid[hy][hx] == 'G' or grid[hy][hx] == 'R':
                                        queue.append([hx, hy])
                                        copy_visited[hy][hx] = True
                                else:
                                    if grid[hy][hx] == grid[yy][xx]:
                                        queue.append([hx, hy])
                                        copy_visited[hy][hx] = True
                            else:
                                if not copy_visited[hy][hx] and grid[hy][hx] == grid[yy][xx]:
                                    queue.append([hx, hy])
                                    copy_visited[hy][hx] = True

                cnt += 1

    return cnt

cnt = 0
for i in range(N):
    for j in range(N):
        if not visited[i][j]:
            dfs(j, i, grid[i][j])
            cnt += 1

for i in range(N):
    for j in range(N):
        if grid[i][j] == 'G':
            grid[i][j] = 'R'

visited = [[False]*N for _ in range(N)]
blindcnt = 0
for i in range(N):
    for j in range(N):
        if not visited[i][j]:
            dfs(j, i, grid[i][j])
            blindcnt += 1

print(cnt, blindcnt)

# bfs 정답
# print(bfs(False))
# print(bfs(True))