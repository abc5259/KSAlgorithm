#include <iostream>
#include <queue>
#include <vector>

struct point
{
    int x, y;
};

int map[9][9];
int c_map[9][9];
int N, M;

void bfs(std::vector<point> const &P)
{
    int wasd[4][2] = { {0, -1}, {0, 1}, {-1, 0}, {1, 0} };
    
    std::queue<point> q;
    for (point p : P) {
        q.push(p);
    }
    
    while (!q.empty())
    {
        point p = q.front();
        q.pop();
        
        for (int i = 0; i < 4; i++) {
            if ((wasd[i][0] + p.x >= 1 && wasd[i][0] + p.x <= M) && (wasd[i][1] + p.y >= 1 && wasd[i][1] + p.y <= N)) {
                if (c_map[wasd[i][1] + p.y][wasd[i][0] + p.x] == 0) {
                    q.push(point{wasd[i][0] + p.x, wasd[i][1] + p.y});
                    c_map[wasd[i][1] + p.y][wasd[i][0] + p.x] = 2;
                }
            }
        }
    }
}

void copymap()
{
    for (int i = 1; i <= N; i++) {
        for (int j = 1; j <= M; j++) {
            c_map[i][j] = map[i][j];
        }
    }
}

int main()
{
    int ans = 0;
    std::cin >> N >> M;
    std::vector<point> p;
    
    for (int i = 1; i <= N; i++) {
        for (int j = 1; j <= M; j++) {
            std::cin >> map[i][j];
            
            if (map[i][j] == 2)
                p.push_back(point{j, i});
        }
    }
    
    std::vector<point> voidList;
    for (int i = 1; i <= N; i++) {
        for (int j = 1; j <= M; j++) {
            if (map[i][j] == 0)
                voidList.push_back(point{j, i});
        }
    }
    
    for (int i = 0; i < voidList.size(); i++) {
        point xy1 = voidList[i];
        
        map[xy1.y][xy1.x] = 1;
        for (int j = i + 1; j < voidList.size(); j++) {
            point xy2 = voidList[j];
            
            map[xy2.y][xy2.x] = 1;
            for (int z = j + 1; z < voidList.size(); z++) {
                point xy3 = voidList[z];
                
                map[xy3.y][xy3.x] = 1;
                copymap();
                bfs(p);
                
                int cnt = 0;
                for (int y = 1; y <= N; y++) {
                    for (int x = 1; x <= M; x++) {
                        if (c_map[y][x] == 0)
                            cnt++;
                    }
                }
                
                if (ans < cnt)
                    ans = cnt;
                
                map[xy3.y][xy3.x] = 0;
            }
            map[xy2.y][xy2.x] = 0;
        }
        map[xy1.y][xy1.x] = 0;
    }
    
    std::cout << ans << std::endl;
}
