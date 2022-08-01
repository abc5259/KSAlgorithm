# 백준 - 1012 [그래프]유기농 배추.py (08/01)
import sys
sys.setrecursionlimit(10000)
input = sys.stdin.readline


def cabbage():
    cnt = 0

    for i in range(N):
        for j in range(M):
            if (not visited[i][j]) and (graph[i][j] == 1):
                dfs(j, i)
                cnt += 1
    return cnt

def dfs(x, y):
    visited[y][x] = True

    for h, w in wasd:
        nY = h + y
        nX = w + x
        if (nY >= 0 and nY < N) and (nX >= 0 and nX < M):
            if (graph[nY][nX] == 1) and (not visited[nY][nX]):
                dfs(nX, nY)



T = int(input())
wasd = [(-1, 0), (1, 0), (0, -1), (0, 1)]

for _ in range(T):
    M, N, K = map(int, input().split())
    graph = [[0]*M for _ in range(N)]
    visited = [[False]*M for _ in range(N)]

    for a in range(K):
        x, y = map(int, input().split())
        graph[y][x] = 1
    
    cnt = cabbage()
    print(cnt)
