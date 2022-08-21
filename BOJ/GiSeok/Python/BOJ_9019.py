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

        if num == goal_num:
            return cmd
        else:
            D = (num * 2) % 10000
            S = num - 1
            if S == -1:
                S = 9999
            L = ((num % 1000)*10) + (num // 1000)
            R = ((num % 10)*1000) + (num // 10)

            if not visited[D]:
                queue.append([D, cmd + 'D'])
                visited[D] = True
            if not visited[S]:
                queue.append([S, cmd + 'S'])
                visited[S] = True
            if not visited[L]:
                queue.append([L, cmd + 'L'])
                visited[L] = True
            if not visited[R]:
                queue.append([R, cmd + 'R'])
                visited[R] = True

if __name__ == "__main__":
    T = int(input())

    for _ in range(T):
        num, goal_num = map(int, input().split())

        print(bfs(num))