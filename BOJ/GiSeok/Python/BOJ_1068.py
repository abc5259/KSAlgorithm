# 백준_1068 - [트리] 트리 (08/16)
# https://www.acmicpc.net/problem/1068
import sys
input = sys.stdin.readline

N = int(input())
node_list = list(map(int, input().split()))
tree = {}

def delete_(key):
    if key in tree.keys():
        for value in tree[key]:
            if value in tree.keys():
                delete_(value)
        del tree[key]

if __name__ == "__main__":
    for i in range(N):
        if node_list[i] == -1:
            if i not in tree.keys():
                tree[i] = []
        else:
            if node_list[i] not in tree.keys():
                tree[node_list[i]] = []
            tree[node_list[i]].append(i)

    del_node = int(input())
    delete_(del_node)
    for key in tree.keys():
        for value in tree[key]:
            if del_node == value:
                tree[key].remove(value)
                break

    leaf = 0
    if tree.keys():
        for key in tree.keys():
            # Tree의 노드가 비어있다면 즉, 잎노드라면
            if not tree[key]:
                leaf += 1
            else: # 비어있지 않다면, 자신이 가진 자식 노드 중 잎노드에 포함되는 노드 찾기
                for value in tree[key]:
                    if value not in tree.keys():
                        leaf += 1
        print(leaf)
    else:
        print(0)