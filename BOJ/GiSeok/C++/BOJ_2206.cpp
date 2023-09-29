#include <iostream>
#include <vector>
#include <queue>

struct point
{
    int x, y;
    int wallBreak;
};

int map[1001][1001];
int c_map[1001][1001];
bool visited[1001][1001][2];
std::vector<point> wall;
int N, M;

int bfs(point P)
{
    int wasd[4][2] = { {0, -1}, {0, 1}, {-1, 0}, {1, 0} };
    
    std::queue<point> q;
    q.push(P);
    visited[P.y][P.x][0] = true;
    
    for (int i = 1; i <= N; i++) {
        for (int j = 1; j <= M; j++) {
            c_map[i][j] = map[i][j];
        }
    }
    c_map[P.y][P.x] = 1;
    
    while (!q.empty())
    {
        point p = q.front();
        q.pop();
        
        if (p.x == M && p.y == N)
            return c_map[p.y][p.x];
 
        for (int i = 0; i < 4; i++) {
            if ((p.x + wasd[i][0] >= 1 && p.x + wasd[i][0] <= M) && (p.y + wasd[i][1] >= 1 && p.y + wasd[i][1] <= N)) {
                if (map[p.y + wasd[i][1]][p.x + wasd[i][0]] == 0) {
                    if (!visited[p.y + wasd[i][1]][p.x + wasd[i][0]][p.wallBreak]) {
                        q.push(point{p.x + wasd[i][0], p.y + wasd[i][1], p.wallBreak});
                        c_map[p.y + wasd[i][1]][p.x + wasd[i][0]] = c_map[p.y][p.x] + 1;
                        visited[p.y + wasd[i][1]][p.x + wasd[i][0]][p.wallBreak] = true;
                    }
                } else if (map[p.y + wasd[i][1]][p.x + wasd[i][0]] == 1 && p.wallBreak == 0) {
                    q.push(point{p.x + wasd[i][0], p.y + wasd[i][1], 1});
                    c_map[p.y + wasd[i][1]][p.x + wasd[i][0]] = c_map[p.y][p.x] + 1;
                }
            }
        }
    }
    
    return -1;
}

int main()
{
    std::cin >> N >> M;
    
    for (int i = 1; i <= N; i++) {
        for (int j = 1; j <= M; j++) {
            scanf("%1d", &map[i][j]);
        }
    }
    
    std::cout << bfs(point{1, 1, 0}) << std::endl;
}
