#include <iostream>

int main()
{
    int n;
    std::cin >> n;
    
    int dp[n+1];
    dp[0] = 1;
    dp[1] = 1;
    
    for (int i = 2; i <= n; i++)
    {
        dp[i] = 0;
        for (int j = 0; j < i; j++)
            dp[i] = (dp[i] % 10007 + dp[j] % 10007) % 10007;
        
        if (!(i % 2)) dp[i] = (dp[i] + 1) % 10007;
    }
    
    std::cout << dp[n] << "\n";
}
