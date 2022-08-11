# 백준_4673 - [브루트 포스]셀프 넘버 (08/11)
self_num = []

for n in range(1, 10001):
    result = n

    while n != 0:
        result += int(n % 10)
        n = int(n / 10)
    
    self_num.append(result)

for n in range(1, 10001):
    if n not in self_num:
        print(n)