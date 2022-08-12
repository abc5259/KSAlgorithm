# 백준_10819 - [브루트 포스]차이를 최대로 (08/13)
import sys
from itertools import permutations
input = sys.stdin.readline

N = int(input())
A = list(map(int, input().split()))

def exp(A):
    sum = 0
    for n in range(N - 1):
        sum += abs(A[n] - A[n+1])

    return sum

max = exp(A)
for lit in list(permutations(A, N)):
    tmp = exp(lit)
    if tmp > max:
        max = tmp

print(max)