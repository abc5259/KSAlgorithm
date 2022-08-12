# 백준_2231 - [브루트 포스]분해합 (08/12)
import sys
input = sys.stdin.readline

N = int(input())

for n in range(N):
    k = n
    sum = n

    while k != 0:
        sum += int(k % 10)
        k = int(k / 10)

    if sum == N:
        print(n)
        break

if n == (N-1):
    print(0)