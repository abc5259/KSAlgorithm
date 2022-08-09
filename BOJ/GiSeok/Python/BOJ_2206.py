# 백준_2206 - 벽 부수고 이동하기[그래프] (08/09)
import sys, copy
from collections import deque
input = sys.stdin.readline

N, M = map(int, input().split())
path = [list(map(int, input().rstrip())) for _ in range(N)]
visited =[[[0, 0] for i in range(M)] for _ in range(N)]
wasd = ((0, -1), (0, 1), (-1, 0), (1, 0))

def bfs(start_x, start_y):
    queue = deque()
    queue.append([start_x, start_y, 0])

    visited[start_y][start_x][0] = True
    dist = copy.deepcopy(path)
    dist[start_y][start_x] = 1

    while queue:
        x, y, wall_break = queue.popleft()
        
        if x == M-1 and y == N-1:
            return dist[y][x]

        for xx, yy in wasd:
            xx += x
            yy += y

            if (0 <= xx < M) and (0 <= yy < N):
                if path[yy][xx] == 0:
                    if not visited[yy][xx][wall_break]:
                        queue.append([xx, yy, wall_break])
                        visited[yy][xx][wall_break] = True
                        dist[yy][xx] = dist[y][x] + 1
                elif path[yy][xx] == 1 and wall_break == 0:
                    if not visited[yy][xx][0]:
                        queue.append([xx, yy, wall_break + 1])
                        visited[yy][xx][0] = True
                        dist[yy][xx] = dist[y][x] + 1
    
    return -1

print(bfs(0, 0))