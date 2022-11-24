import sys
from itertools import combinations
input = sys.stdin.readline

N = int(input())
ans = []

for i in range(1, 11):
    for c in combinations([0, 1, 2, 3, 4, 5, 6, 7, 8, 9], i):
        num = list(c)
        num.sort(reverse=True)
        
        st = ""
        for n in num:
            st += str(n)
        ans.append(int(st))

ans.sort()
if len(ans) <= N:
    print(-1)
else:
    print(ans[N])