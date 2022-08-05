# 백준 - 1697 숨바꼭질.py (08/05)
from collections import deque
import sys
input = sys.stdin.readline

N, K = map(int, input().split())
if N > K:
    graph = [0] * ((N+1)*2)
    visited = [False] * ((N+1)*2)
    scope = N
else:
    graph = [0] * ((K+1)*2)
    visited = [False] * ((K+1)*2)
    scope = K*2

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
            if (0 <= vv <= scope) and (not visited[vv]):
                queue.append(vv)
                visited[vv] = True
                graph[vv] = graph[v] + 1

print(bfs(N))