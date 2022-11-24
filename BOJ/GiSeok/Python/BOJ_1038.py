import sys
input = sys.stdin.readline

N = int(input())
lenN = int(str(N))
ans = []

def backtracking(num):
    ans.append(num)
    if (num % 10) == 0:
        return

    n = num % 10
    for i in range(n):
        backtracking((num*10)+i)

for i in range(10):
    backtracking(i)

ans.sort()
if len(ans) <= N:
    print(-1)
else:
    print(ans[N])