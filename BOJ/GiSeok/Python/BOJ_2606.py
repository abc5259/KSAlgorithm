# BaekJoon - 2606 [그래프]바이러스 (07/31)
import sys
sys.setrecursionlimit(10000)

# 인접 행렬 방식
# graphOfComputers = [[0]*(computers+1) for i in range(computers+1)]
# def VirusDFS(v1):
#     global howManyVirus
#     howManyVirus += 1
#     visited[v1] = True
    
#     for i in range(1, computers+1):
#         if ((graphOfComputers[v1][i] == 1) and (not visited[i])):
#             VirusDFS(i)

# 인접 리스트 방식
def VirusDFS(v1):
    global howManyVirus
    howManyVirus += 1
    visited[v1] = True
    
    for i in graphOfComputers[v1]:
        if not visited[i]:
            VirusDFS(i)

computers = int(sys.stdin.readline())
pairOfComputers = int(sys.stdin.readline())

graphOfComputers = [[] for _ in range(computers+1)]
visited = [False]*(computers+1)
howManyVirus = -1

for i in range(pairOfComputers):
    v1, v2 = map(int, sys.stdin.readline().split())
    
    graphOfComputers[v1].append(v2)
    graphOfComputers[v2].append(v1)

VirusDFS(1)

print(howManyVirus)