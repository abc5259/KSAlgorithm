# BaekJoon - 4963 [그래프]섬의 개수 (07/04)
import sys
sys.setrecursionlimit(10000)

def dfsIsland(r, c):
        visited[r][c] = True

        for i in range(8):
            if (dicHeight[i] + r >= 0 and dicHeight[i] + r < mapHeight) and (dicWidth[i] + c >= 0 and dicWidth[i] + c < mapWidth):
                newRow = dicHeight[i] + r
                newCol = dicWidth[i] + c
                if not visited[newRow][newCol] and islandMap[newRow][newCol] == 1:
                    dfsIsland(newRow, newCol)

dicHeight = [-1, 1, 0, 0, -1, -1, 1, 1]
dicWidth = [0, 0, -1, 1, -1, 1, -1, 1]
while True:
    mapWidth, mapHeight = map(int, sys.stdin.readline().split())
    if mapWidth == 0 and mapHeight == 0:
        break
    visited = [[False for i in range(mapWidth)] for j in range(mapHeight)]
    islandMap = []
    for i in range(mapHeight):
        islandMap.append(list(map(int, sys.stdin.readline().split())))

    islandCount = 0
    for i in range(mapHeight):
        for j in range(mapWidth):
            if islandMap[i][j] == 1 and not visited[i][j]:
                dfsIsland(i, j)
                islandCount += 1

    print(islandCount)