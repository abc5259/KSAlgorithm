# BaekJoon - 11724 [그래프]연결 요소의 개수 (07/04)
from collections import deque
import sys
# sys.setrecursionlimit(10000)

class Graph:
    def __init__(self, N, M):
        self.graph = [[] for _ in range(N+1)]
        self.visited = [False] * (N+1)
        self.queue = deque()
        self.N = N
        self.M = M
    
    def addEdge(self, n1, n2):
        self.graph[n1].append(n2)
        self.graph[n2].append(n1)

    # def dfs(self, v):
    #     """
    #     깊이 우선 탐색
    #     """
    #     self.visited[v] = True;

    #     for i in self.graph[v]:
    #         if not self.visited[i]:
    #             self.dfs(i)
    
    def bfs(self, v):
        """
        너비 우선 탐색
        """
        self.queue.append(v)

        while self.queue:
            v1 = self.queue.popleft()
            self.visited[v1] = True
            for i in self.graph[v1]:
                if not self.visited[i]:
                    self.queue.append(i)
                    self.visited[i] = True


N, M = map(int, sys.stdin.readline().split())
gr1 = Graph(N, M)

for i in range(M):
    n1, n2 = map(int, sys.stdin.readline().split())
    gr1.addEdge(n1, n2)

connectGraph = 0
for i in range(1, N+1):
    if not gr1.visited[i]:
        gr1.bfs(i)
        connectGraph += 1

print(connectGraph)