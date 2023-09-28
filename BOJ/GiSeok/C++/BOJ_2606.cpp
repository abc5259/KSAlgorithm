#include <iostream>

bool computer[101][101];
bool visited[101];
int cnt = 0;

void dfs(int v)
{
    visited[v] = true;
    
    for (int i = 1; i < 101; i++) {
        if (computer[v][i] == true && !visited[i]) {
            cnt++;
            dfs(i);
        }
    }
}

int main()
{
    int N, M;
    
    std::cin >> N;
    std::cin >> M;
    
    for (int i = 0; i < M; i++)
    {
        int v1, v2;
        std::cin >> v1 >> v2;
        
        computer[v1][v2] = true;
        computer[v2][v1] = true;
    }
    
    dfs(1);
    
    std::cout << cnt << std::endl;
    
    return 0;
}
