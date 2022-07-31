# BaekJoon - 1753 [우선순위 큐]최단경로 (07/31)
# 다익스트라 알고리즘 (우선순위 큐)
import heapq
import sys
input = sys.stdin.readline

inf = 9999999
v, e = map(int, input().split())
startV = int(input())
graph = [[] for _ in range(v+1)]

for i in range(1, e+1):
    v1, v2, cost = map(int, input().split())
    graph[v1].append([v2, cost])


def DijkstraPriority(start):
    dijkstra = [inf for _ in range(v+1)]
    priority = []

    dijkstra[start] = 0
    heapq.heappush(priority, (0, start))

    while priority:
        dist, vv = heapq.heappop(priority)

        if dist > dijkstra[vv]:
            continue

        for v1, cost in graph[vv]:
            cst = dist + cost
            if cst < dijkstra[v1]:
                dijkstra[v1] = cst
                heapq.heappush(priority, (cst, v1))
    
    return dijkstra

shortage = DijkstraPriority(startV)
for i in range(1, (v+1)):
    if shortage[i] == inf:
        print("INF")
    else:
        print(shortage[i])