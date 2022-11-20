import sys
input = sys.stdin.readline

N = int(input())
board = [list(map(int, input().split())) for _ in range(N)]
mNum = 0

def board_move(wasd):
    if (wasd == 0): # 위
        for column in range(N):
            for row in range(N-1):
                for new_row in range(row+1, N):
                    if (board[row][column] != 0 and board[new_row][column] != 0):
                        if (board[row][column] == board[new_row][column]):
                            board[row][column] += board[new_row][column]
                            board[new_row][column] = 0
                            break
                        else:
                            break
                    elif (board[row][column] == 0 and board[new_row][column] != 0):
                        board[row][column] = board[new_row][column]
                        board[new_row][column] = 0
    elif (wasd == 1): # 아래
        for column in range(N):
            for row in range(N-1, 0, -1):
                for new_row in range(row-1, -1, -1):
                    if (board[row][column] != 0 and board[new_row][column] != 0):
                        if (board[row][column] == board[new_row][column]):
                            board[row][column] += board[new_row][column]
                            board[new_row][column] = 0
                            break
                        else:
                            break
                    elif (board[row][column] == 0 and board[new_row][column] != 0):
                        board[row][column] = board[new_row][column]
                        board[new_row][column] = 0
    elif (wasd == 2): # 왼쪽
        for row in range(N):
            for column in range(N-1):
                for new_column in range(column+1, N):
                    if (board[row][column] != 0 and board[row][new_column] != 0):
                        if (board[row][column] == board[row][new_column]):
                            board[row][column] += board[row][new_column]
                            board[row][new_column] = 0
                            break
                        else:
                            break
                    elif (board[row][column] == 0 and board[row][new_column] != 0):
                        board[row][column] = board[row][new_column]
                        board[row][new_column] = 0
    elif (wasd == 3):
        for row in range(N):
            for column in range(N-1, 0, -1):
                for new_column in range(column-1, -1, -1):
                    if (board[row][column] != 0 and board[row][new_column] != 0):
                        if (board[row][column] == board[row][new_column]):
                            board[row][column] += board[row][new_column]
                            board[row][new_column] = 0
                            break
                        else:
                            break
                    elif (board[row][column] == 0 and board[row][new_column] != 0):
                        board[row][column] = board[row][new_column]
                        board[row][new_column] = 0

def n_2048(deep):
    global mNum, board
    if (deep == 5):
        for i in range(N):
            mNum = max(mNum, max(board[i]))
        return
    
    bd = [b[:] for b in board]
    for i in range(4):
        board_move(i)
        n_2048(deep + 1)
        board = [b[:] for b in bd]

n_2048(0)
print(mNum)