# 1931 - [그리디] 회의실 배정 (08/29)
# https://www.acmicpc.net/problem/1931
import sys
input = sys.stdin.readline

N = int(input())
meetings = sorted([list(map(int, input().split())) for _ in range(N)], key=lambda x: (x[1],x[0]))

end = cnt = 0
for meet in meetings:
    if (end <= meet[0]):
        end = meet[1]
        cnt += 1

print(cnt)