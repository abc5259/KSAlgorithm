# 백준_18111 - [브루트 포스] 마인크래프트 (08/19)
# https://www.acmicpc.net/problem/18111
import sys
input = sys.stdin.readline

N, M, inventory = map(int, input().split())
# 지도를 1차원 배열로 저장
ground = list(map(int, input().split()))
for _ in range(N-1):
    ground += list(map(int, input().split()))
ground.sort(reverse=True)
# 내림차순 정렬을 하는 이유는 제일 큰 값을 먼저 만나야 인벤토리에 블럭을 넣어
# 다른 바닥을 채울 수 있기 때문이다.
# 어차피 구조가 바뀌어도 바닥을 다듬는 총 시간은 같다.

def minecraft():
    height = 0
    ans = 1000000000

    # 2 2 0
    # 256 256
    # 0 0
    # 의 경우 중간인 128 높이가 정답이 된다. (=처음 입력으로 주어진 높이로만 맞출 필요가 없다.)
    for num in range(257):
        time = 0
        copy_inventory = inventory

        for r in range(N*M):
            if ground[r] > num:
                # 높이가 높으면 땅을 파야한다. 땅을 파는 시간 = 2s
                time += (ground[r] - num) * 2
                copy_inventory += (ground[r] - num)
            elif ground[r] < num:
                # 높이가 낮으면 땅을 채워야한다. 땅을 채우는 시간 = 1s
                # 제일 큰 높이부터 땅을 다듬기 때문에 인벤토리에 블럭이 넣어지는데,
                # 작은 높이를 만난 순간 인벤토리에 충분한 블럭이 없으면 다음 칸부터는 채울 수 없다.
                if (num - ground[r]) <= copy_inventory:
                    time += (num - ground[r])
                    copy_inventory -= (num - ground[r])
                else:
                    time = 1000000000
                    break

        if time <= ans:
            if time == ans:
                if height < num:
                    height = num
            else:
                ans = time
                height = num

    return [ans, height]

if __name__ == "__main__":
    t, h = minecraft()
    print(t, h)