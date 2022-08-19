# 백준_16236 - [그래프] 아기 상어 (08/17)
# https://www.acmicpc.net/problem/16236
import sys
from collections import deque
input = sys.stdin.readline

N = int(input())
ocean = [list(map(int, input().split())) for _ in range(N)]
wasd = ((-1, 0), (1, 0), (0, -1), (0, 1))

def bfs(start_r, start_c):
    global visited, min_dist, min_r, min_c, eating
    queue = deque()
    queue.append([start_r, start_c])
    visited[start_r][start_c] = True

    while queue:
        row, column = queue.popleft()

        for hr, hc in wasd:
            hr += row
            hc += column
            if (0 <= hr < N) and (0 <= hc < N):
                if level >= ocean[hr][hc] and not visited[hr][hc]:
                    visited[hr][hc] = True
                    check[hr][hc] = check[row][column] + 1

                    if ocean[hr][hc] == 0 or ocean[hr][hc] == level:
                        queue.append([hr, hc])
                    elif ocean[hr][hc] != 0 and ocean[hr][hc] != level:
                        # 최소 거리가 똑같은 곳이 여러개라면 가장 위쪽에 있는 물고기를 먹고,
                        # 같은 위쪽에도 똑같은 거리를 가진 물고기가 여러 마리라면
                        # 가장 왼쪽에 있는 물고기를 먹는다.
                        if min_dist == check[hr][hc]:
                            if min_r > hr:
                                min_r = hr
                                min_c = hc
                            elif min_r == hr:
                                if min_c > hc:
                                    min_c = hc
                        elif min_dist > check[hr][hc]:
                            min_r = hr
                            min_c = hc
                            min_dist = check[hr][hc]


if __name__ == "__main__":
    # 입력된 지도에서 아기 상어를 찾아 좌표를 저장하고
    # 그 위치를 0으로 만들어서 다음번에 지나갈 수 있도록 함
    for i in range(N):
        if 9 in ocean[i]:
            min_r = i
            min_c = ocean[i].index(9)
            ocean[i][min_c] = 0
            break

    cnt_move, level, eating = [0, 2, 0]
    while True:
        # 물고기를 먹기 위해 지나간 길은 다시 지나갈 수 있기 때문에
        # 매번 초기화해준다.
        check = [[0] * N for _ in range(N)]
        visited = [[False]*N for _ in range(N)]
        # min_dist는 bfs에서 최소 거리를 저장하는 용도로 사용됨.
        # 만약 갈 수 있는 (먹을 수 있는 물고기) 곳이 없다면, min_dist의 값은 변화하지 않는다.
        min_dist = 100000000

        bfs(min_r, min_c)

        # 먹을 수 있는 물고기가 있다면,
        if min_dist != 100000000:
            # 먹고 레벨 변화
            eating += 1
            if eating == level:
                level += 1
                eating = 0

            # 그리고 최종적으로 선택된 최소 거리 좌표의 거리를 더함
            cnt_move += check[min_r][min_c]
            ocean[min_r][min_c] = 0
        else:
            break

    print(cnt_move)