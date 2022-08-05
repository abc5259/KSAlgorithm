# 백준 - 14502 연구소.py (08/05)
from collections import deque
import sys, copy
input = sys.stdin.readline

N, M = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(N)]
wasd = ((0, -1), (0, 1), (-1, 0), (1, 0))
queue = deque()
void_list = []
max = 0

# 0 is void
# 1 is wall
# 2 is virus

def bfs(copyGraph):
    for i in range(N):
        for j in range(M):
            if copyGraph[i][j] == 2:
                queue.append([j, i])

    while queue:
        vx, vy = queue.popleft()
        for hx, hy in wasd:
            hx += vx
            hy += vy
            if (hx >= 0 and hx < M) and (hy >= 0 and hy < N):
                if copyGraph[hy][hx] == 0:
                    queue.append([hx, hy])
                    copyGraph[hy][hx] = 2
    
    global max
    cnt = 0
    for i in range(N):
        for j in range(M):
            if copyGraph[i][j] == 0:
                cnt += 1
    
    if cnt > max:
        max = cnt

def wall():
    for i in range(N):
        for j in range(M):
            if graph[i][j] == 0:
                void_list.append([j, i])
    
    for i in range(len(void_list)):
        x1, y1 = void_list[i]
        graph[y1][x1] = 1
        for j in range(i+1, len(void_list)):
            x2, y2 = void_list[j]
            graph[y2][x2] = 1
            for z in range(j+1, len(void_list)):
                x3, y3 = void_list[z]
                graph[y3][x3] = 1

                copy_graph = copy.deepcopy(graph)
                bfs(copy_graph)

                graph[y3][x3] = 0
            graph[y2][x2] = 0
        graph[y1][x1] = 0


wall()
print(max)