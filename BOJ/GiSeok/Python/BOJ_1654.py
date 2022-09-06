# 1654 - [이분 탐색] 랜선 자르기 (09/06)
# https://www.acmicpc.net/problem/1654
import sys
sys.setrecursionlimit(10000)
input = sys.stdin.readline

N, K = map(int, input().split())
lanList = [int(input()) for _ in range(N)]

def lanCut(start, end):
    mid = (start + end) // 2

    cnt = 0
    for num in lanList:
        cnt += num // mid
    
    if start > end:
        return end
    elif cnt >= K:
        return lanCut(mid + 1, end)
    else:
        return lanCut(start, mid - 1)

print(lanCut(1, max(lanList)))