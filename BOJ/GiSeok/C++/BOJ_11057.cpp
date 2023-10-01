#include <iostream>

int main()
{
    int N;
    std::cin >> N;
    
    int dp[N + 1][10];
    for (int i = 0; i < 10; i++)
        dp[1][i] = 1;
    
    for (int i = 2; i <= N; i++) {
        for (int j = 0; j < 10; j++) {
            dp[i][j] = 0;
            for (int z = 0; z <= j; z++)
                dp[i][j] = (dp[i][j] + dp[i - 1][z]) % 10007;
        }
    }
    
    int ans = 0;
    for (int i = 0; i < 10; i++)
        ans = (ans + dp[N][i]) % 10007;
    
    std::cout << ans << "\n";
}
