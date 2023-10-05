#include <iostream>
#include <queue>
#include <vector>
#include <cstring>

int color[20001];
int N, M;

bool bfs(int v, std::vector<std::vector<int>> &vec)
{
    std::queue<int> q;
    q.push(v);
    color[v] = 1;
    
    while (!q.empty())
    {
        int p = q.front();
        q.pop();
        
        for (int v2 : vec[p]) {
            if (color[v2] == -1) {
                q.push(v2);
                color[v2] = (color[p] == 1 ? 0 : 1);
            } else {
                if (color[v2] == color[p])
                    return false;
            }
        }
    }
    
    return true;
}

int main()
{
    int t;
    std::cin >> t;
    
    for (int i = 0; i < t; i++) {
        std::cin >> N >> M;
        
        std::vector<std::vector<int>> vec;
        vec.resize(N+1);
        
        for (int z = 0; z < M; z++) {
            int v1, v2;
            std::cin >> v1 >> v2;
            
            vec[v1].push_back(v2);
            vec[v2].push_back(v1);
        }
        
        memset(color, -1, sizeof(int) * 20001);
        
        bool isNo = false;
        for (int i = 1; i <= N; i++) {
            if (color[i] == -1) {
                if (!bfs(i, vec))
                    isNo = true;
            }
        }
        
        std::cout << (isNo ? "NO" : "YES") << "\n";
    }
}
