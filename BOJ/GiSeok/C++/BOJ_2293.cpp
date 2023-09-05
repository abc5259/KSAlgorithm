#include <iostream>
#include <cstring>
#include <algorithm>
using namespace std;

class BOJ_2293
{
public:
    static int start()
    {
        int n, k;
        cin >> n >> k;

        int dp[k + 1];
        memset(dp, 0, sizeof(int)*(k+1));
        dp[0] = 1;

        int coins[n];
        for (int i = 0; i < n; i++)
            cin >> coins[i];
        sort(coins, coins+n);

        for (auto coin : coins) {
            for (int c = coin; c <= k; c++) {
                dp[c] += dp[c-coin];
            }
        }

        return dp[k];
    }
};

int main()
{
    cout << BOJ_2293::start() << endl;

    return 0;
}