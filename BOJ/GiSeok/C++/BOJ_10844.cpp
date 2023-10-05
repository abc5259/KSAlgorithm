#include <iostream>

int main()
{
    int N;
    std::cin >> N;
    
    int dp[N + 1][10];
    dp[1][0] = 0;
    for (int i = 1; i < 10; i++)
        dp[1][i] = 1;
    
    for (int i = 2; i <= N; i++) {
        for (int j = 0; j < 10; j++) {
            if (j == 0)
                dp[i][j] = dp[i - 1][j + 1] % 1000000000;
            else if (j == 9)
                dp[i][j] = dp[i - 1][j - 1] % 1000000000;
            else
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % 1000000000;
        }
    }
    
    int ans = 0;
    for (int i = 0; i < 10; i++)
        ans = (ans + dp[N][i]) % 1000000000;
    std::cout << ans << "\n";
}
