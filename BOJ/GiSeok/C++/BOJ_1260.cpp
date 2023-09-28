#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
#include <string.h>

struct Edge
{
    int src, dest;
};

class Graph
{
public:
    std::vector<std::vector<int>> adList;
    bool* visited;
    
    Graph(std::vector<Edge> const &edge, int n)
    {
        for (int i = 0; i <= n; i++)
            adList.push_back(std::vector<int>());
        
        for (Edge e : edge) {
            adList[e.src].push_back(e.dest);
            adList[e.dest].push_back(e.src);
        }
        
        for (int i = 1; i < adList.size(); i++)
            sort(adList[i].begin(), adList[i].end());
        
        visited = new bool[n + 1];
        memset(visited, false, sizeof(bool) * (n+1));
    }
    
    void DFS(int v)
    {
        visited[v] = true;
        std::cout << v << " ";
        
        for (int n : adList[v])
            if (!visited[n])
                DFS(n);
    }
    
    void BFS(int v)
    {
        visited = new bool[adList.size()];
        memset(visited, false, sizeof(bool) * adList.size());
        
        std::queue<int> q;
        q.push(v);
        visited[v] = true;
        
        while (!q.empty())
        {
            int n = q.front();
            q.pop();
            
            std::cout << n << " ";
            
            for (int c : adList[n]) {
                if (!visited[c]) {
                    q.push(c);
                    visited[c] = true;
                }
            }
        }
    }
};

int main()
{
   int N, M, V;
   
   std::cin >> N >> M >> V;
   std::vector<Edge> edge;
   
   for (int i = 0; i < M; i++) {
       int a, b;
       std::cin >> a >> b;
       edge.push_back((Edge{a, b}));
   }
   
   Graph gh(edge, N);
   
   gh.DFS(V);
   std::cout << std::endl;
   
   gh.BFS(V);
   std::cout << std::endl;
   
   return 0;
}
