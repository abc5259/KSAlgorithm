# 백준_2011 - [DP] 암호코드 (08/26)
# https://www.acmicpc.net/problem/2011
import sys
input = sys.stdin.readline

# 25114
# 2     | dp[1] = 1
# 25    | dp[2] = dp[1] if num(25) > 26 else dp[1] + 1      => 2
# 251   | dp[3] = dp[2] if num(51) > 26 else dp[2] + dp[1]  => 2
# 2511  | dp[4] = dp[3] if num(11) > 26 else dp[3] + dp[2]  => 4
# 25114 | dp[5] = dp[4] if num(14) > 26 else dp[4] + dp[3]  => 6

N = list(input().rstrip())
dp = [0]*5001

dp[0] = 1 if int(N[0]) > 0 else 0   # 입력이 0으로 시작하는 경우 ex) 0, 01, 022
dp[1] = dp[0]                       # 해석이 불가함

for i in range(2, len(N)+1):
    num = int(N[i-2] + N[i-1])

    # 끝이 0인 경우 'ex) 1220' 122 + 0 으로 해석이 불가하고 12 + 20으로만 해석해야함.
    if N[i - 1] == '0':
        dp[i] -= (dp[i-1] % 1000000)
    
    # 끝에 두 수를 붙힌 수가 10보다 작으면 'ex) 1207' 120 + 7로 해석은 가능하나 12 + 07 으로는 해석이 불가함.
    dp[i] += dp[i-1] % 1000000 if num > 26 or num < 10 else (dp[i-1] + dp[i-2]) % 1000000

print(dp[len(N)])