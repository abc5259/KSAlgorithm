# 백준_2798 - [브루트 포스]블랙잭 (08/12)
import sys
input = sys.stdin.readline

card_num, goal_num = map(int, input().split())
card_list = list(map(int, input().split()))
card_nums = []

for i in range(card_num-2):
    for j in range(i+1, card_num-1):
        for z in range(j+1, card_num):
            sum = card_list[i] + card_list[j] + card_list[z]

            if sum > goal_num:
                continue
            card_nums.append(sum)

print(max(card_nums))
