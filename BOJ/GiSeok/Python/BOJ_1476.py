# 백준_1476 - [브루트 포스]날짜 계산 (08/12)
import sys
input = sys.stdin.readline

earth, sun, moon = map(int, input().split())
year = 0

e = s = m = 0
while e != earth or s != sun or m != moon:
    e += 1
    s += 1
    m += 1
    year += 1

    if e == 16:
        e = 1
    if s == 29:
        s = 1
    if m == 20:
        m = 1

print(year)