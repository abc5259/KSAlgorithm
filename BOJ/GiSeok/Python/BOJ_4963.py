# BaekJoon - 4963 [그래프]섬의 개수 (07/04)
import sys
sys.setrecursionlimit(10000)

def dfsIsland(r, c):
        visited[r][c] = True

        for i in range(8):
            newRow = dicHeight[i] + r
            newCol = dicWidth[i] + c
            if (newRow >= 0 and newRow < mapHeight) and (newCol >= 0 and newCol < mapWidth):
                if not visited[newRow][newCol] and islandMap[newRow][newCol] == 1:
                    dfsIsland(newRow, newCol)

dicHeight = [-1, 1, 0, 0, -1, -1, 1, 1]
dicWidth = [0, 0, -1, 1, -1, 1, -1, 1]
while True:
    mapWidth, mapHeight = map(int, sys.stdin.readline().split())
    if mapWidth == 0 and mapHeight == 0:
        break
    visited = [[False]*(mapWidth) for j in range(mapHeight)]
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