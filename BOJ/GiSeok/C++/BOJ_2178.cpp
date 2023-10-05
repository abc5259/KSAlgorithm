#include <iostream>
#include <queue>

int N, M;
int map[101][101];

struct point
{
    int x, y;
    int dep;
};

int bfs(point P)
{
    int wasd[4][2] = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    
    std::queue<point> q;
    q.push(P);
    map[P.y][P.x] = 0;
    
    while (!q.empty())
    {
        point p = q.front();
        q.pop();
        
        if (p.x == M-1 && p.y == N-1)
            return p.dep;
        
        for (int i = 0; i < 4; i++) {
            if (((p.x + wasd[i][0]) >= 0 && (p.x + wasd[i][0]) <= M) && ((p.y + wasd[i][1]) >= 0 && (p.y + wasd[i][1]) <= N)) {
                if (map[p.y + wasd[i][1]][p.x + wasd[i][0]] != 0) {
                    q.push(point{p.x + wasd[i][0], p.y + wasd[i][1], p.dep + 1});
                    map[p.y + wasd[i][1]][p.x + wasd[i][0]] = 0;
                }
            }
        }
    }
    
    return 0;
}

int main()
{
    std::cin >> N >> M;
    
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++)
            scanf("%1d", &map[i][j]);
    }
    
    int count = bfs({0, 0, 1});
    std::cout << count << std::endl;
}
