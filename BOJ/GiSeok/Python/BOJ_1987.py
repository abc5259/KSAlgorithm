# 백준_1987 - [그래프]알파벳 (08/11)
import sys
sys.setrecursionlimit(10000)
input = sys.stdin.readline

R, C = map(int, input().split())
board = [list(input().rstrip()) for _ in range(R)]
wasd = ((0, -1), (0, 1), (-1, 0), (1, 0))
ans = 0

def dfs(x, y, alpha_set):
    global ans
    alpha_set.add(board[y][x])

    if ans < len(alpha_set):
        ans = len(alpha_set)

    for hx, hy in wasd:
        hx += x
        hy += y

        if (0 <= hx < C) and (0 <= hy < R):
            if board[hy][hx] not in alpha_set:
                dfs(hx, hy, alpha_set)

    alpha_set.remove(board[y][x])

dfs(0, 0, set())
print(ans)