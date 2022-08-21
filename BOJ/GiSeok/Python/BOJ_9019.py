# 백준_9019 - [그래프] DSLR (08/21)
# https://www.acmicpc.net/problem/9019
import sys
from collections import deque
input = sys.stdin.readline

def bfs(start_num):
    queue = deque()
    queue.append([start_num, ""])
    visited = [False] * 10000

    while queue:
        num, cmd = queue.popleft()

        if int(num) == int(goal_num):
            return cmd
        else:
            D = str((int(num) * 2) % 10000)
            D = ('0'*(4-len(D))) + D

            S = str(int(num) - 1)
            if int(S) == -1:
                S = '9999'
            S = ('0'*(4-len(S))) + S

            L = num[1:] + num[0]
            R = num[-1] + num[0:-1]

            if not visited[int(D)]:
                queue.append([D, cmd + 'D'])
                visited[int(D)] = True
            if not visited[int(S)]:
                queue.append([S, cmd + 'S'])
                visited[int(S)] = True
            if not visited[int(L)]:
                queue.append([L, cmd + 'L'])
                visited[int(L)] = True
            if not visited[int(R)]:
                queue.append([R, cmd + 'R'])
                visited[int(R)] = True

if __name__ == "__main__":
    T = int(input())

    for _ in range(T):
        num, goal_num = input().split()
        num = ('0'*(4-len(num))) + num

        print(bfs(num))