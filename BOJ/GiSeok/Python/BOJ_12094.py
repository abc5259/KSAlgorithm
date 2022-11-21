import sys
input = sys.stdin.readline

N = int(input())
board = [list(map(int, input().split())) for _ in range(N)]
mNum = 0
for i in range(N):
    mNum = max(mNum, max(board[i]))
max_num = 0
max_list = [0 for _ in range(11)]

def board_move(wasd):
    if (wasd == 0): # 위
        for column in range(N):
            top = 0
            for row in range(1, N):
                if board[row][column] != 0:
                    temp = board[row][column]
                    board[row][column] = 0
                
                    if board[top][column] == 0:
                        board[top][column] = temp
                    elif board[top][column] == temp:
                        board[top][column] <<= 1
                        top += 1
                    else:
                        top += 1
                        board[top][column] = temp
    elif (wasd == 1): # 아래
        for column in range(N):
            top = N-1
            for row in range(N-2, -1, -1):
                if board[row][column] != 0:
                    temp = board[row][column]
                    board[row][column] = 0
                
                    if board[top][column] == 0:
                        board[top][column] = temp
                    elif board[top][column] == temp:
                        board[top][column] <<= 1
                        top -= 1
                    else:
                        top -= 1
                        board[top][column] = temp
    elif (wasd == 2): # 왼쪽
        for row in range(N):
            top = 0
            for column in range(1, N):
                if board[row][column] != 0:
                    temp = board[row][column]
                    board[row][column] = 0
                
                    if board[row][top] == 0:
                        board[row][top] = temp
                    elif board[row][top] == temp:
                        board[row][top] <<= 1
                        top += 1
                    else:
                        top += 1
                        board[row][top] = temp
    elif (wasd == 3):
        for row in range(N):
            top = N-1
            for column in range(N-2, -1, -1):
                if board[row][column] != 0:
                    temp = board[row][column]
                    board[row][column] = 0
                
                    if board[row][top] == 0:
                        board[row][top] = temp
                    elif board[row][top] == temp:
                        board[row][top] <<= 1
                        top -= 1
                    else:
                        top -= 1
                        board[row][top] = temp

def n_2048(deep):
    global mNum, board, max_num

    max_num = 0
    for i in range(N):
        max_num = max(max_num, max(board[i]))
    if (max_num <= max_list[deep]): return

    if (deep == 10):
        mNum = max(mNum, max_num)
        max_num = mNum
        if (max_list[10] < max_num):
            for i in range(10, 0, -1):
                max_list[i] = max_num
                max_num //= 2
        return
    
    bd = [b[:] for b in board]
    for i in range(4):
        board_move(i)
        if (bd == board):
            continue
        n_2048(deep + 1)
        board = [b[:] for b in bd]

n_2048(0)
print(mNum)