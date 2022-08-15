# 백준_10971 - [백트래킹] 외판원 순회 2 (08/15)
# https://www.acmicpc.net/problem/10971
import sys
input = sys.stdin.readline

N = int(input())
list_map = [list(map(int, input().split())) for _ in range(N)]
visited = []

ans = 1000000*N + 1

def search(city_i, sum):
    global ans
    visited.append(city_i)

    if len(visited) == N and list_map[city_i][i] != 0:
        ans = min(ans, sum + list_map[city_i][i])
    
    for j in range(N):
        if j not in visited and list_map[city_i][j] != 0:
            search(j, sum + list_map[city_i][j])

    visited.remove(city_i)

for i in range(N):
    search(i, 0)

print(ans)