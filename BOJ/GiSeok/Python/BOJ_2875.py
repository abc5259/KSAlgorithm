# 2875 - [그리디] 대회 or 인턴
# https://www.acmicpc.net/problem/2875
import sys
input = sys.stdin.readline

girl, boy, intern = map(int, input().split())

team = min(girl//2, boy)
boy -= team
girl -= (team * 2)

if (boy + girl) < intern:
    intern -= (boy + girl)
    if intern % 3 == 0: intern -= 1
    intern //= 3

    team -= (intern + 1)

print(team)