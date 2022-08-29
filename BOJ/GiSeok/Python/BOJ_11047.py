# 11047 - [그리디] 동전 0 (08/29)
# https://www.acmicpc.net/problem/11047
import sys
input = sys.stdin.readline

N, K = map(int, input().split())
coins = [int(input()) for _ in range(N)]
cnt = 0

for i in reversed(range(N)):
    if K == 0: break
    if K < coins[i]:
        continue
    cnt += K // coins[i]
    K %= coins[i]

print(cnt)