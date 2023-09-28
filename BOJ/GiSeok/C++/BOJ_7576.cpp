#include <iostream>
#include <queue>
#include <vector>

struct point
{
    int x, y;
    int day;
};

int map[1001][1001];
int N, M;

int bfs(std::vector<point> const &P)
{
    int wasd[4][2] = { {0, -1}, {0, 1}, {-1, 0}, {1, 0} };
    
    std::queue<point> q;
    for (point p : P) {
        q.push(p);
        map[p.y][p.x] = -1;
    }
    
    point p;
    while (!q.empty())
    {
        p = q.front();
        q.pop();
        
        for (int i = 0; i < 4; i++) {
            if ((p.x + wasd[i][0] >= 1 && p.x + wasd[i][0] <= M) && (p.y + wasd[i][1] >= 1 && p.y + wasd[i][1] <= N)) {
                if (map[p.y + wasd[i][1]][p.x + wasd[i][0]] != -1) {
                    q.push(point{p.x + wasd[i][0], p.y + wasd[i][1], p.day + 1});
                    map[p.y + wasd[i][1]][p.x + wasd[i][0]] = -1;
                }
            }
        }
    }
    
    for (int i = 1; i <= N; i++) {
        for (int j = 1; j <= M; j++) {
            if (map[i][j] == 0)
                return -1;
        }
    }
    
    return p.day;
}

int main()
{
    std::cin >> M >> N;
    std::vector<point> start;
    
    for (int i = 1; i <= N; i++) {
        for (int j = 1; j <= M; j++) {
            std::cin >> map[i][j];
            
            if (map[i][j] == 1)
                start.push_back(point{j, i, 0});
        }
    }
    
    std::cout << bfs(start) << std::endl;
    
    return 0;
}
