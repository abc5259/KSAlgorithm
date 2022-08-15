# 백준_1963 - 소수 경로 (08/15)
# https://www.acmicpc.net/problem/1963
import sys, math
from collections import deque
input = sys.stdin.readline

T = int(input())

def is_prime(num):
    # 약수의 곱은 대칭을 이룬다.
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

        # 각 i(1~4)번째 자리 수를 바꾸기 위해 string 요소를 가진 list로 변환
        for i in range(4):
            for changer in range(10):
                # i에 따른 각 자리 수를 0~9의 수로 바꾸어 소수인지 판별해본다.
                tmp = list(str(N))
                tmp[i] = str(changer)
                tmp = int(''.join(tmp))

                # 네 자리 소수가 아니면 x
                if tmp < 1000:
                    continue
                
                # 이미 추가한 소수는 다시 추가할 필요 x
                if is_prime(tmp):
                    if tmp not in collecter:
                        queue.append([tmp, cnt + 1])
                        collecter.add(tmp)

    # 이 문제에서 Impossible이 나오는 경우는 없다.
    print("Impossible")

for _ in range(T):
    start_num, goal_num = map(int, input().split())
    
    bfs(start_num)