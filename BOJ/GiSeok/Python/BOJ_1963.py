# 백준_1963 - 소수 경로 (08/15)
import sys, math
from collections import deque
input = sys.stdin.readline

T = int(input())

def is_prime(num):
    for i in range(2, int(math.sqrt(num)) + 1):
        if num % i == 0:
            return False
    
    return True

def bfs(num):
    queue = deque()
    collecter = set()
    queue.append([num, 0])

    while queue:
        N, cnt = queue.popleft()

        if N == goal_num:
            print(cnt)
            return

        N = str(N)
        for i in range(4):
            for changer in range(10):
                tmp = list(N)
                tmp[i] = str(changer)
                tmp = int(''.join(tmp))

                if tmp < 1000:
                    continue
                
                if is_prime(tmp):
                    if tmp not in collecter:
                        queue.append([tmp, cnt + 1])
                        collecter.add(tmp)

    print("Impossible")


for _ in range(T):
    start_num, goal_num = map(int, input().split())
    
    bfs(start_num)

