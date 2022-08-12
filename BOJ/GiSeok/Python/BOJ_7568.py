# 백준_7568 - [브루트 포스]덩치 (08/12)
import sys
input = sys.stdin.readline

N = int(input())
human = tuple(tuple(map(int, input().split())) for _ in range(N))

for cm, kg in human:
    rank = 1
    for height, weight in human:
        if (height > cm) and (weight > kg):
            rank += 1
    
    print(rank, end=' ')
print()