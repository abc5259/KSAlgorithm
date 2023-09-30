#include <iostream>

int N, M;
bool v[1001][1001];
bool visited[1001];

void dfs(int v1)
{
    visited[v1] = true;
    
    for (int i = 1; i < 1001; i++) {
        if (v[v1][i] && !visited[i]) {
            dfs(i);
        }
    }
}

int main()
{
    std::cin >> N >> M;
    
    for (int i = 0; i < M; i++) {
        int v1, v2;
        std::cin >> v1 >> v2;
        
        v[v1][v2] = true;
        v[v2][v1] = true;
    }
    
    int cnt = 0;
    for (int i = 1; i <= N; i++) {
        if (!visited[i]) {
            dfs(i);
            cnt++;
        }
    }
    
    std::cout << cnt << std::endl;
    return 0;
}
