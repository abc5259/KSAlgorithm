# 백준_1991 - [트리] 트리 순회 (08/16)
# https://www.acmicpc.net/problem/1991
import sys
input = sys.stdin.readline

class Node:
    def __init__(self, data, left=None, right=None):
        self.left = left
        self.right = right
        self.data = data

class Tree:
    def __init__(self, head):
        self.root = head

    def find(self, node, data):
        global ans
        if self.root == None:
            return
        if data == node.data:
            ans = node
            return

        if node.left != None:
            self.find(node.left, data)
        if node.right != None:
            self.find(node.right, data)
    
    # node.left가 None이어서 node == None인 경우가 생길 수 있다.
    def pre_order(self, node):
        if node != None:
            print(node.data, end='')
            self.pre_order(node.left)
            self.pre_order(node.right)
    def in_order(self, node):
        if node != None:
            self.in_order(node.left)
            print(node.data, end='')
            self.in_order(node.right)
    def re_order(self, node):
        if node != None:
            self.re_order(node.left)
            self.re_order(node.right)
            print(node.data, end='')

N = int(input())
ans = None

for i in range(N):
    data, l_data, r_data = input().rstrip().split()

    if i == 0:
        tree = Tree(Node(data))

    # 입력받은 데이터를 갖는 노드를 찾는다.
    tree.find(tree.root, data)

    if l_data != '.':
        ans.left = Node(l_data)
    if r_data != '.':
        ans.right = Node(r_data)

tree.pre_order(tree.root)
print()
tree.in_order(tree.root)
print()
tree.re_order(tree.root)
print()