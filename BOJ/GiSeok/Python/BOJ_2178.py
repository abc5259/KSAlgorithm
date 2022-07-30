# BaekJoon - 2178 [그래프]미로 탐색 (07/30)
from collections import deque
import sys

def MazeRunnerBFS(x, y, cost):
    """
    BFS 탐색
    """
    queue = deque()
    queue.append([x, y, cost])
    visited[y][x] = True

    while queue:
        nX, nY, nCost = queue.popleft()

        if (nX == (width-1) and nY == (height-1)):
            return nCost

        for i in range(4):
            nWid = nX + wasdWidth[i]
            nHei = nY + wasdHeight[i]
            if ((nWid >= 0 and nWid < width) and (nHei >= 0 and nHei < height)):
                if ((not visited[nHei][nWid]) and mazeMap[nHei][nWid] == 1):
                    queue.append([nWid, nHei, nCost+1])
                    visited[nHei][nWid] = True
        

wasdHeight = [-1, 1, 0, 0]
wasdWidth = [0, 0, -1, 1]
height, width = map(int, sys.stdin.readline().split())
mazeMap = []
for i in range(height):
    mazeMap.append(list(map(int, sys.stdin.readline().rstrip())))

visited = [[False]*width for i in range(height)]


print(MazeRunnerBFS(0, 0, 1))