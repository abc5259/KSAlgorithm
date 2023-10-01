#include <iostream>
#include <algorithm>

int main()
{
    int T;
    std::cin >> T;
    
    for (int i = 0; i < T; i++)
    {
        int n;
        std::cin >> n;
        
        int dp[3][n];
        int map[2][n];
        
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < n; j++)
                std::cin >> map[i][j];
        
        dp[0][0] = map[0][0];
        dp[1][0] = map[1][0];
        dp[2][0] = 0;
        for (int i = 1; i < n; i++) {
            dp[0][i] = std::max(dp[1][i-1] + map[0][i], dp[2][i-1] + map[0][i]);
            dp[1][i] = std::max(dp[0][i-1] + map[1][i], dp[2][i-1] + map[1][i]);
            dp[2][i] = std::max(dp[0][i-1], dp[1][i-1]);
        }
        
        int max = (dp[0][n-1] > dp[1][n-1]) ? (dp[0][n-1] > dp[2][n-1]) ? dp[0][n-1] : dp[2][n-1] : (dp[1][n-1] > dp[2][n-1]) ? dp[1][n-1] : dp[2][n-1];
        std::cout << max << '\n';
    }
}
