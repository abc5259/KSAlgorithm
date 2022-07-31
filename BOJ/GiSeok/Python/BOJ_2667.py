# BaekJoon - 2667 [그래프]단지번호 붙이기 (07/31)
import sys
sys.setrecursionlimit(10000)
input = sys.stdin.readline

#
N = int(input())
graph = []
aparts = 0
numOfAparts = []

for _ in range(N):
    graph.append(list(map(int, input().rstrip())))
visited = [[False]*N for _ in range(N)]
wasd = [(-1, 0), (1, 0), (0, -1), (0, 1)]
#

def apartment():
    global aparts
    for i in range(N):
        for j in range(N):
            if (graph[i][j] == 1) and (not visited[i][j]):
                numOfAparts.append(0)
                dfs(j, i)
                aparts += 1

def dfs(x, y):
    visited[y][x] = True
    numOfAparts[aparts] += 1

    for h, w in wasd:
        nY = h + y
        nX = w + x
        if (nY >= 0 and nY < N) and (nX >= 0 and nX < N):
            if (graph[nY][nX] == 1) and (not visited[nY][nX]):
                dfs(nX, nY)

#
apartment()
print(aparts)
numOfAparts.sort()
for num in numOfAparts:
    print(num)
#