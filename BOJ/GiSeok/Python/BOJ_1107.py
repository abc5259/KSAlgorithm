# 백준_1107 - [브루트 포스]리모컨 (08/12)
import sys
input = sys.stdin.readline

goal_ch = int(input())
broke_num = int(input())
if broke_num != 0:
    broke_btu = set(map(int, input().split()))
else:
    broke_btu = set()

ans = abs(100 - goal_ch)

for i in range(1000001):
    n = set(list(map(int, str(i))))

    if not n & broke_btu:
        ans = min(ans, len(str(i)) + abs(goal_ch - i))

print(ans)