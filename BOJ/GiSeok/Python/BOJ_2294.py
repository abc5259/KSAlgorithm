import sys
input = sys.stdin.readline

n, k = map(int, input().split())
coin = [int(input()) for _ in range(n)]
coin.sort()
dp = [1000001 for i in range(k+1)]

dp[0] = 0
for i in range(n):
    for j in range(coin[i], k+1):
        if (dp[j - coin[i]] + 1) < dp[j]:
            dp[j] = (dp[j - coin[i]] + 1)

if (dp[k] == 1000001):
    print(-1)
else:
    print(dp[k])