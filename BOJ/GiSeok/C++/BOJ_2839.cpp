#include <iostream>
#include <algorithm>

int min(int n1, int n2)
{
    if (n1 > n2)
        return n2;
    else
        return n1;
}

int main()
{
    int N;
    std::cin >> N;
    
    int dp[N + 1];
    std::fill(dp, dp+(N+1), 5001);
    
    dp[3] = 1;
    dp[5] = 1;
    
    for (int i = 6; i < N + 1; i++)
        dp[i] = min(dp[i-3], dp[i-5]) + 1;
    
    std::cout << ((dp[N] > 5000) ? -1 : dp[N]) << std::endl;
}
