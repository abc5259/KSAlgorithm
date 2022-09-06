# 1654 - [이분 탐색] 랜선 자르기 (09/06)
# https://www.acmicpc.net/problem/1654
import sys
sys.setrecursionlimit(10000)
input = sys.stdin.readline

N, K = map(int, input().split())
numList = [int(input()) for _ in range(N)]

def lanCable(start, end):
    mid = (start + end) // 2

    cnt = 0
    for num in numList:
        cnt += num // mid
    
    if start > end:
        return end
    elif cnt >= K:
        return lanCable(mid + 1, end)
    else:
        return lanCable(start, mid - 1)

print(lanCable(1, max(numList)))