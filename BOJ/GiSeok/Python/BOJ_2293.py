import sys
input = sys.stdin.readline

n, k = map(int, input().split())
num = [int(input()) for _ in range(n)]
dp = [0 for _ in range(k+1)];

dp[0] = 1
for i in range(n):
    for j in range(num[i], k+1):
        dp[j] += dp[j - num[i]]

print(dp[k])