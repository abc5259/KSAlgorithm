# 백준 - 1697 숨바꼭질.py (08/05)
from collections import deque
import sys
input = sys.stdin.readline

N, K = map(int, input().split())
scope = 100001
graph = [0] * scope
visited = [False] * scope

def bfs(start):
    queue = deque()
    queue.append(start)
    visited[start] = True

    while queue:
        v = queue.popleft()
        if (v == K):
            return graph[v]
        dx = [v+1, v-1, v*2]

        for vv in dx:
            if (0 <= vv < scope) and (not visited[vv]):
                queue.append(vv)
                visited[vv] = True
                graph[vv] = graph[v] + 1

print(bfs(N))