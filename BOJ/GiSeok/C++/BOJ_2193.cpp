#include <iostream>

int main()
{
    int N;
    std::cin >> N;

    long long dp[N+1][2];
    dp[1][0] = 0;
    dp[1][1] = 1;
    
    for (int i = 2; i <= N; i++) {
        for (int j = 0; j < 2; j++) {
            if (j) dp[i][j] = dp[i-1][0];
            else dp[i][j] = dp[i-1][0] + dp[i-1][1];
        }
    }
    
    std::cout << dp[N][0] + dp[N][1] << "\n";
}
