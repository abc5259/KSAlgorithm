#include <iostream>
#include <vector>
using namespace std;

struct point
{
    int x, y;
}; // 그리드 내 좌표 저장을 위한 구조체

class node
{
    public:
        node* parent;
        point position;

        double f;
        double g;
        double h;

        node(node* p, point pos)
        {
            parent = p;
            position = pos;
            f = 0;
            g = 0;
            h = 0;
        }
}; // a* 알고리즘에선 각 그리드 정보를 저장해야하므로 node라는 객체를 이용하여 관리

double getDistanceFormula(point xy1, point xy2)
{
    int x1 = xy1.x < xy2.x ? xy1.x : xy2.x;
    int x2 = xy1.x > xy2.x ? xy1.x : xy2.x;

    int y1 = xy1.y < xy2.y ? xy1.y : xy2.y;
    int y2 = xy1.y > xy2.y ? xy1.y : xy2.y;

    return sqrt(pow(x2-x1, 2) + pow(y2-y1, 2));
} // 두 점 사이의 거리 구하는 함수

node* find(vector<node*> list, point p)
{
    for (auto &lt : list) {
        if (lt->position.x == p.x && lt->position.y == p.y)
            return lt;
    }

    return NULL;
}

void makePath(int map[][10], vector<node*> &closeList)
{
    node* node = closeList.back();
    
    while (node != NULL)
    {
        map[node->position.y][node->position.x] = 7;
        node = node->parent;
    }
} // 도착지에 도착 후, 어떤 경로로 도착했는지 부모 노드를 쫓아간다.

void Astar(int map[][10], point start, point end)
{
    int wasd[8][2] = { {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1} }; // 상하좌우, 대각선 이동을 위한 배열
    vector<node*> openList;  // 현재 그리드에서 가능한 모든 경로를 담는 openlist.
    vector<node*> closeList; // 현재 그리드까지 오는데 거친 그리드 정보를 담는 closelist

    node* startNode = new node(NULL, start);
    openList.push_back(startNode);

    node* current;
    while (!openList.empty())
    {
        double smallF = INFINITY;
        node* minNode = NULL;
        int index = 0, minIndex = 0;
        for (auto &list : openList) {
            if (list->f < smallF) {
                minNode = list;
                smallF = list->f;
                minIndex = index;
            }
            index++;
        } // openlist에서 f 값이 가장 작은 노드를 찾는 것으로 시작한다.

        current = minNode;
        openList.erase(openList.begin() + minIndex); // vector의 erase는 iterator 정보로 원소를 삭제하므로, 위에서 구한 인덱스를 이용해 f 값이 가장 작은 노드를 제거한다.
        closeList.push_back(current);                // 현재까지 f 값이 가장 작은 노드는 거쳐야 하는 그리드로 판단하므로 closelist에 넣어 두 번 방문하지 않는다.

        if (current->position.x == end.x && current->position.y == end.y) // 만약 현재 그리드 좌표가 도착지 좌표라면 종료
            break;
        
        for (int i = 0; i < 8; i++) { // 8방향 경로 추가를 위해 8회 반복
            // 어느 방향이든 맵의 크기를 벗어나면 안된다.
            if ((current->position.x + wasd[i][0] >= 0 && current->position.x + wasd[i][0] < 10) && (current->position.y + wasd[i][1] >= 0 && current->position.y + wasd[i][1] < 10)) {
                point nextPosition = {current->position.x + wasd[i][0], current->position.y + wasd[i][1]};

                if (map[nextPosition.y][nextPosition.x] == 1) // 새 좌표가 벽이라면 다음 방향으로 넘어간다.
                    continue;

                node* nextNode = new node(current, nextPosition);

                nextNode->g = current->g;
                if (i % 2 != 0)
                    nextNode->g += 1.4;
                else
                    nextNode->g += 1;
                nextNode->h = getDistanceFormula(nextPosition, end);
                nextNode->f = nextNode->g + nextNode->h;
                // g, h, f 값을 초기화

                if (find(closeList, nextPosition) == NULL) { // closelist에 nextPosition에 해당하는 좌표가 있는지, 즉 해당 좌표의 정보를 가지고 있는지 판단한다. 있으면, 두 번 방문 x
                    node* n = find(openList, nextPosition);  // 없다면, openlist에 있는지 확인한다.
                    if (n != NULL) {
                        if (n->f > nextNode->f) {            // 새로 구한 그리드가 openlist에 있을 경우에 f 값을 보고 더 작은 그리드 정보로 바꾸어준다. 그래야 해당 부모 경로를 거치는 최단경로가 만들어질 수 있다.
                            n->parent = current;
                            n->f = nextNode->f;
                            n->g = nextNode->g;
                            n->h = nextNode->h;
                            continue;
                        }
                    }
                    openList.push_back(nextNode);            // 해당 사항이 없으면 추가
                }
            }
        }
    }

    makePath(map, closeList);
}

void printMap(int map[][10])
{
    for (int y = 0; y < 10; y++) {
        for (int x = 0; x < 10; x++) {
            cout << map[y][x];
        }
        cout << endl;
    }
}

int main()
{
    int map[10][10] = { {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0} };
    point start = { 0, 0 };
    point end = { 8, 0 };

    Astar(map, start, end);
    printMap(map);
}