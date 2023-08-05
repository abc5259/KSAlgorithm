/*
    랜덤한 맵을 만들기 위한 절차적 콘텐츠 생성 (PCG) 방식의 BSP 알고리즘 (C++)
    0 -> 허공 void
    3 -> 던전 dungeon
    7 -> 길 path
*/

#include <iostream>
#include <cmath>
#include <stdlib.h>
#include <time.h>

using namespace std;

#define mapWidth 60
#define mapHeight 60

int map[mapHeight][mapWidth];
int maxDepth = 4;
double minRatio = 0.4, maxRatio = 0.7; // 방의 크기와 같은 랜덤 요소에 사용되는 최소, 최대 비율

// 배열 내 위치 정보를 저장하기 위한 구조체
// 왼쪽 상단 위치에 해당함
struct Rect
{
    int x; int y;
    int width; int height;
};

class Node
{
    public:
        Node* leftNode;
        Node* rightNode;
        Node* parentNode;
        Rect rect;
        Rect room;
        int split;
    
    public:
        Node(int x, int y, int width, int height, int split);
};

Node::Node(int x, int y, int width, int height, int split)
{
    rect.x = x; rect.y = y;
    rect.width = width; rect.height = height;
    this->split = split;
}

// void initMap()  // 맵의 가장자리를 1로 바꾼다.
// {
//     for (int i = 0; i < mapHeight; i++) {
//         for (int j = 0; j < mapWidth; j++) {
//             if (i == 0 || i == mapHeight-1)
//                 map[i][j] = 1;
//             else {
//                 map[i][0] = 1;
//                 map[i][mapWidth-1] = 1;
//             }
//         }
//     }
// }

void printMap()
{
    for (int i = 0; i < mapHeight; i++) {
        for (int j = 0; j < mapWidth; j++)
            cout << map[i][j];
        cout << endl;
    }
}

int random(int low, int high) // low ~ high 범위의 랜덤 정수 하나를 뽑는다.
{
    return low + rand() % (high - low + 1);
}

void Divide(Node *node, int depth) // 공간을 나누면서 트리 생성함
{
    if (depth == maxDepth) return;

    // width와 height 중 긴 쪽을 선택해서 width면 세로로 분할, height이면 가로로 분할
    int maxLen = node->rect.width > node->rect.height ? node->rect.width : node->rect.height;
    // 너무 작거나 큰 방이 생성되는 것을 막기 위해 비율을 정해서 랜덤 추출
    int split = random(round(maxLen * minRatio), round(maxLen * maxRatio));

    if (node->rect.width >= node->rect.height) // 현재 노드의 가로가 더 크다면, 세로로 나눈다.
    {
        // width, height이 같은 크기라도 출력 시에는 height이 더 크게 출력되므로, 같은 크기라도 세로로 나누는 것이 낫다. 안그러면 방이 더 작아보임
        node->leftNode = new Node(node->rect.x, node->rect.y, split, node->rect.height, split);
        node->rightNode = new Node(node->rect.x + split, node->rect.y, node->rect.width - split, node->rect.height, split);

        //for (int i = node->leftNode->rect.y; i < node->leftNode->rect.y + node->leftNode->rect.height; i++)
            //map[i][node->rightNode->rect.x] = 1;
    } else {                                   // 현재 노드의 세로가 더 크다면, 가로로 나눈다.
        node->leftNode = new Node(node->rect.x, node->rect.y, node->rect.width, split, split);
        node->rightNode = new Node(node->rect.x, node->rect.y + split, node->rect.width, node->rect.height - split, split);

        //for (int i = node->leftNode->rect.x; i < node->leftNode->rect.x + node->leftNode->rect.width; i++)
            //map[node->rightNode->rect.y][i] = 1;
    }

    Divide(node->leftNode, depth + 1);
    Divide(node->rightNode, depth + 1);
}

void PrintRoom(Node* node, int depth)
{
    if (depth == maxDepth)
    {
        for (int j = node->room.y; j < node->room.y + node->room.height; j++)
            for (int i = node->room.x; i < node->room.x + node->room.width; i++)
                map[j][i] = 3;
    } else {
        PrintRoom(node->leftNode, depth + 1);
        PrintRoom(node->rightNode, depth + 1);
    }
}

Rect GenerateRoom(Node* node, int depth)
{
    Rect rect;

    if (depth == maxDepth)
    {
        // 나뉜 공간의 크기를 벗어나지 않는 선에서 width, height, x, y를 랜덤하게 정해준다.
        rect.width = random(int(node->rect.width * minRatio), int(node->rect.width * maxRatio));
        rect.height = random(int(node->rect.height * minRatio), int(node->rect.height * maxRatio));

        rect.x = random(node->rect.x + 1, node->rect.x + (node->rect.width-rect.width));
        rect.y = random(node->rect.y + 1, node->rect.y + (node->rect.height-rect.height));
    } else
    {
        node->leftNode->room = GenerateRoom(node->leftNode, depth + 1);
        node->rightNode->room = GenerateRoom(node->rightNode, depth + 1);

        if (random(0, 2)) // 랜덤하게 선택하여 부모에게 왼쪽 혹은 오른쪽 노드의 방 정보를 넘겨준다.
            rect = node->leftNode->room;
        else
            rect = node->rightNode->room;
    }

    return rect;
}

void SplitHorizon(Node* node) // 세로로 분할된 공간의 길 이어줄 때 사용
{
    int lCenterY = node->leftNode->room.y + node->leftNode->room.height;
    int lCenterX = node->leftNode->room.x + (node->leftNode->room.width/2);

    int rCenterY = node->rightNode->room.y;
    int rCenterX = node->rightNode->room.x + (node->rightNode->room.width/2);

    for (int y = lCenterY; y <= node->leftNode->rect.y + node->leftNode->split; y++)
        map[y][lCenterX] = 7;

    int from = lCenterX <= rCenterX ? lCenterX : rCenterX;
    int to = lCenterX <= rCenterX ? rCenterX : lCenterX;

    for (int x = from; x <= to; x++)
        map[node->leftNode->rect.y + node->leftNode->split][x] = 7;

    for (int y = node->leftNode->rect.y + node->leftNode->split; y < rCenterY; y++)
        map[y][rCenterX] = 7;
}

void SplitVertical(Node* node) // 가로로 분할된 공간의 길 이어줄 때 사용
{
    int lCenterY = node->leftNode->room.y + (node->leftNode->room.height/2);
    int lCenterX = node->leftNode->room.x + node->leftNode->room.width;

    int rCenterY = node->rightNode->room.y + (node->rightNode->room.height/2);
    int rCenterX = node->rightNode->room.x;

    for (int x = lCenterX; x <= node->leftNode->rect.x + node->leftNode->split; x++)
        map[lCenterY][x] = 7;

    int from = lCenterY <= rCenterY ? lCenterY : rCenterY;
    int to = lCenterY <= rCenterY ? rCenterY : lCenterY;

    for (int y = from; y <= to; y++)
        map[y][node->leftNode->rect.x + node->leftNode->split] = 7;

    for (int x = node->leftNode->rect.x + node->leftNode->split; x < rCenterX; x++)
        map[rCenterY][x] = 7;
}

void GeneratePath(Node* node, int depth) // 길 생성
{
    if (depth == maxDepth) return;

    GeneratePath(node->leftNode, depth + 1);
    GeneratePath(node->rightNode, depth + 1);

    if (node->leftNode->rect.x == node->rightNode->rect.x)
        SplitHorizon(node);
    else
        SplitVertical(node);
}

int main(void)
{
    srand(time(NULL)); // 난수 생성
    Node* root = new Node(0, 0, mapWidth, mapHeight, 0); // 트리의 root 노드 생성
    memset(map, 0, sizeof(map));

    Divide(root, 0);
    GenerateRoom(root, 0);
    GeneratePath(root, 0);

    // 공간 정보로 길을 그려주고, 방을 그려주어 방을 통과하는 길이 보이지 않도록 함
    PrintRoom(root, 0);
    printMap();

    return 0;
}